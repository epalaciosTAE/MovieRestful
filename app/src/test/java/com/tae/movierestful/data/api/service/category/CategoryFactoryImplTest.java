package com.tae.movierestful.data.api.service.category;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tae.movierestful.data.api.constants.ApiConstants;
import com.tae.movierestful.data.local.category.CategoryType;
import com.tae.movierestful.data.local.category.Celebrity;
import com.tae.movierestful.data.local.category.CommonCategory;
import com.tae.movierestful.data.local.category.Movie;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Eduardo on 21/05/2016.
 */
public class CategoryFactoryImplTest {

    private CategoryFactoryImpl factory;

    @Before
    public void setUp() {
        factory = new CategoryFactoryImpl();
    }

    @Test
    public void testCreateMovie() throws Exception {
        Movie movie = new Movie();
        movie.setId(12232);
        movie.setTitle("Star Wars");
        movie.setReleaseDate("2012-5-25");
        movie.setDescription("a description");
        movie.setImage("http://image/poster");
        movie.setRating(7.14);
        List<CommonCategory> commonCategories = new ArrayList<>(1);
        commonCategories.add(movie);

        JsonObject object = new JsonObject();
        object.addProperty(ApiConstants.ID, 12232);
        object.addProperty(ApiConstants.TITLE, "Star Wars");
        object.addProperty(ApiConstants.RELEASE_DATE, "2012-5-25");
        object.addProperty(ApiConstants.OVERVIEW, "a description");
        object.addProperty(ApiConstants.POSTER_PATH, "http://image/poster");
        object.addProperty(ApiConstants.VOTE_AVERAGE, 7.14);
        JsonArray array = new JsonArray();
        array.add(object);

        assertTrue(factory.createMovie(CategoryType.MOVIE, array).size() > 0);
        assertEquals(commonCategories.get(0).getId(),
                factory.createMovie(CategoryType.MOVIE, array).get(0).getId());
    }

    @Test
    public void testCreateSerie() throws Exception {
        Movie movie = new Movie();
        movie.setId(12232);
        movie.setTitle("Star Wars");
        movie.setReleaseDate("2012-5-25");
        movie.setDescription("a description");
        movie.setImage("http://image/poster");
        movie.setRating(7.14);
        List<CommonCategory> commonCategories = new ArrayList<>(1);
        commonCategories.add(movie);

        JsonObject object = new JsonObject();
        object.addProperty(ApiConstants.ID, 12232);
        object.addProperty(ApiConstants.NAME, "Star Wars");
        object.addProperty(ApiConstants.FIRST_AIR_DATE, "2012-5-25");
        object.addProperty(ApiConstants.OVERVIEW, "a description");
        object.addProperty(ApiConstants.POSTER_PATH, "http://image/poster");
        object.addProperty(ApiConstants.VOTE_AVERAGE, 7.14);
        JsonArray array = new JsonArray();
        array.add(object);

        assertTrue(factory.createMovie(CategoryType.SERIE, array).size() > 0);
        assertEquals(commonCategories.get(0).getId(),
                factory.createMovie(CategoryType.SERIE, array).get(0).getId());
    }

    @Test
    public void testCreateCelebrity() throws Exception {
        Celebrity celebrity = new Celebrity();
        celebrity.setId(12232);
        celebrity.setTitle("Star Wars");
        celebrity.setImage("http://image/poster");
        List<CommonCategory> commonCategories = new ArrayList<>(1);
        commonCategories.add(celebrity);

        JsonObject object = new JsonObject();
        object.addProperty(ApiConstants.ID, 12232);
        object.addProperty(ApiConstants.NAME, "Star Wars");
        object.addProperty(ApiConstants.PROFILE_PATH, "http://image/poster");
        JsonArray array = new JsonArray();
        array.add(object);

        assertTrue(factory.createCelebrity(array).size() > 0);
        assertEquals(commonCategories.get(0).getId(),
                factory.createCelebrity(array).get(0).getId());
    }
}