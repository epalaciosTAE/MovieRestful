package com.tae.movierestful.data.api.service.detail;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tae.movierestful.data.api.service.api.ResponseMapper;
import com.tae.movierestful.data.local.detail.CelebrityDetail;
import com.tae.movierestful.data.local.detail.CommonDetail;
import com.tae.movierestful.data.local.detail.MovieDetail;
import com.tae.movierestful.data.local.detail.Season;
import com.tae.movierestful.data.local.detail.SerieDetail;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class DetailFactoryImpl extends ResponseMapper implements DetailFactory {

    @Inject
    public DetailFactoryImpl() {
    }

    @Override
    public CommonDetail createMovieDetail(JsonObject response) {
        MovieDetail movieDetail = new MovieDetail();
        movieDetail.setTitle(getTitle(response));
        movieDetail.setDescription(getOverview(response));
        movieDetail.setImage(getPosterPath(response));
        JsonArray productionCompanies = getProductionCompanies(response);
        List<String> companies = convertToList(productionCompanies);
        movieDetail.setProductionCompanies(companies);
        movieDetail.setReleaseDate(getReleaseDate(response));
        movieDetail.setBudget(getBudget(response));
        movieDetail.setRating(getVoteAverage(response));
        movieDetail.setRunTime(getRuntime(response));
        JsonArray genresArray = getGenres(response);
        List<String> genres = convertToList(genresArray);
        movieDetail.setGenres(genres);
        return movieDetail;
    }

    @Override
    public CommonDetail createSerieDetail(JsonObject response) {
        SerieDetail serie = new SerieDetail();
        serie.setName(getName(response));
        serie.setImage(getPosterPath(response));
        serie.setRating(getVoteAverage(response));
        serie.setReleaseDate(getFirstAirDate(response));
        serie.setLastEpisodeDate(getLastAirDate(response));
        serie.setDescription(getOverview(response));
        serie.setEpisodesTotal(getNumberOfEpisodes(response));
        serie.setSeasonTotal(getNumberOfSeasons(response));
        JsonArray networksResponse = getNetworks(response);
        List<String> networks = convertToList(networksResponse);
        serie.setNetworks(networks);
        JsonArray genresArray = getGenres(response);
        List<String> genres = convertToList(genresArray);
        serie.setGenres(genres);
        JsonArray seasonResponse = getSeasons(response);
        List<Season> seasons = getSeasons(seasonResponse);
        serie.setSeasons(seasons);
        return serie;
    }

    @Override
    public CommonDetail createCelebrityDetail(JsonObject response) {
        CelebrityDetail celebrity = new CelebrityDetail();
        celebrity.setName(getName(response));
        celebrity.setBiography(getBiography(response));
        celebrity.setBirthday(getBirthday(response));
        celebrity.setDeathDay(getDeathday(response));
        celebrity.setImage(getProfilePath(response));
        celebrity.setPlaceOfBirth(getPlaceOfBirth(response));
        celebrity.setPopularity(getPopularity(response));
        celebrity.setGenre(getGender(response));
        return celebrity;
    }

    @NonNull
    private List<Season> getSeasons(JsonArray seasonResponse) {
        List<Season> seasons = new ArrayList<>(seasonResponse.size());
        for (JsonElement element : seasonResponse) {
            Season season = new Season();
            season.setEpisodesCount(getEpisodesCount(element));
            season.setSeasonNumber(getSeasonNumber(element));
            season.setImage(getPosterPath(element.getAsJsonObject()));
            seasons.add(season);
        }
        return seasons;
    }
}
