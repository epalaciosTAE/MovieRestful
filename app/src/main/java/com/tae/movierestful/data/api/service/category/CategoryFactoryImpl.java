package com.tae.movierestful.data.api.service.category;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.tae.movierestful.data.api.constants.ApiConstants;
import com.tae.movierestful.data.api.service.api.ResponseMapper;
import com.tae.movierestful.data.local.category.CategoryType;
import com.tae.movierestful.data.local.category.Celebrity;
import com.tae.movierestful.data.local.category.CommonCategory;
import com.tae.movierestful.data.local.category.Movie;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class CategoryFactoryImpl extends ResponseMapper implements CategoryFactory {

    @Inject
    public CategoryFactoryImpl() {
    }

    @Override
    public List<CommonCategory> createMovie(String categoryType, JsonArray results) {
        List<CommonCategory> popularMovies = new ArrayList<>(results.size());
        for (JsonElement element : results) {
            Movie movie = new Movie();
            movie.setId(getId(element));
            handleType(categoryType, element, movie);
            movie.setDescription(getOverview(element.getAsJsonObject()));
            movie.setImage(getPosterPath(element.getAsJsonObject()));
            movie.setRating(getVoteAverage(element.getAsJsonObject()));
            popularMovies.add(movie);
        }
        return popularMovies;
    }


    @Override
    public List<CommonCategory> createCelebrity(JsonArray results) {
        List<CommonCategory> popularCelebrities = new ArrayList<>(results.size());
        for (JsonElement element : results) {
            Celebrity celebrity = new Celebrity();
            celebrity.setId(getId(element));
            celebrity.setTitle(getName(element.getAsJsonObject()));
            celebrity.setImage(getProfilePath(element.getAsJsonObject()));
            popularCelebrities.add(celebrity);
        }
        return popularCelebrities;
    }


    private void handleType(String categoryType, JsonElement element, Movie movie) {
        if (categoryType.equals(CategoryType.MOVIE)) {
            movie.setType(CategoryType.MOVIE);
            movie.setTitle(getTitle(element.getAsJsonObject()));
            movie.setReleaseDate(getReleaseDate(element.getAsJsonObject()));
        } else {
            movie.setType(CategoryType.SERIE);
            movie.setTitle(getName(element.getAsJsonObject()));
            movie.setReleaseDate(getFirstAirDate(element.getAsJsonObject()));
        }
    }
}
