package com.tae.movierestful.data.api.service.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tae.movierestful.data.api.constants.ApiConstants;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Eduardo on 21/05/2016.
 */
public class ResponseMapperTest {

    private JsonElement element;

    private ResponseMapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper = new ResponseMapper();
    }

    @Test
    public void testGetId() throws Exception {
        JsonObject object = getJsonObjectLong(ApiConstants.ID, 1223);
        assertEquals(1223, mapper.getId(object));
    }

    @Test
    public void testGetGenderIsFemale() throws Exception {
        JsonObject object = getJsonObjectInt(ApiConstants.GENDER, 1);
        assertEquals(1, mapper.getGender(object));
        assertTrue(mapper.getGender(object) == 1);
    }


    @Test
    public void testGetGenderIsMale() throws Exception {
        JsonObject object = getJsonObjectInt(ApiConstants.GENDER, 2);
        assertEquals(2, mapper.getGender(object));
        assertTrue(mapper.getGender(object) == 2);
    }


    @Test
    public void testGetGenderUnknown() throws Exception {
        JsonObject object = getJsonObjectInt(ApiConstants.GENDER,0);
        assertEquals(0, mapper.getGender(object));
        assertTrue(mapper.getGender(object) < 1 || mapper.getGender(object) > 2);
    }

    @Test
    public void testGetPopularity() throws Exception {
        JsonObject object = getJsonObjectDouble(ApiConstants.POPULARITY, 12.23);
        assertEquals(12.23, mapper.getPopularity(object));
    }

    @Test
    public void testGetPlaceOfBirth() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.PLACE_OF_BIRTH, "London");
        assertEquals("London", mapper.getPlaceOfBirth(object));
    }

    @Test
    public void testGetProfilePath() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.PROFILE_PATH, "/image/path");
        assertEquals("/image/path", mapper.getProfilePath(object));
    }

    @Test
    public void testGetDeathday() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.DEATHDAY, "1992-3-12");
        assertEquals("1992-3-12", mapper.getDeathday(object));
    }

    @Test
    public void testGetBirthday() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.BIRTHDAY, "1952-3-12");
        assertEquals("1952-3-12", mapper.getBirthday(object));
    }

    @Test
    public void testGetBiography() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.BIOGRAPHY, "a biography");
        assertEquals("a biography", mapper.getBiography(object));
    }

    @Test
    public void testGetNumberOfSeasons() throws Exception {
        JsonObject object = getJsonObjectInt(ApiConstants.NUMBER_OF_SEASONS, 3);
        assertEquals(3, mapper.getNumberOfSeasons(object));
    }

    @Test
    public void testGetSeasonNumber() throws Exception {
        JsonObject object = getJsonObjectInt(ApiConstants.SEASON_NUMBER, 2);
        assertEquals(2, mapper.getSeasonNumber(object));
    }

    @Test
    public void testGetEpisodesCount() throws Exception {
        JsonObject object = getJsonObjectInt(ApiConstants.EPISODE_COUNT, 33);
        assertEquals(33, mapper.getEpisodesCount(object));
    }

    @Test
    public void testGetLastAirDate() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.LAST_AIR_DATE, "2016-04-25");
        assertEquals("2016-04-25", mapper.getLastAirDate(object));
    }

    @Test
    public void testGetNumberOfEpisodes() throws Exception {
        JsonObject object = getJsonObjectInt(ApiConstants.NUMBER_OF_EPISODES, 23);
        assertEquals(23, mapper.getNumberOfEpisodes(object));
    }

    @Test
    public void testGetName() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.NAME, "vader");
        assertEquals("vader", mapper.getName(object));
    }

    @Test
    public void testGetRuntime() throws Exception {
        JsonObject object = getJsonObjectInt(ApiConstants.RUNTIME, 123);
        assertEquals(123, mapper.getRuntime(object));
    }

    @Test
    public void testGetVoteAverage() throws Exception {
        JsonObject object = getJsonObjectDouble(ApiConstants.VOTE_AVERAGE, 6.123);
        assertEquals(6.123, mapper.getVoteAverage(object));
    }

    @Test
    public void testGetBudget() throws Exception {
        JsonObject object = getJsonObjectLong(ApiConstants.BUDGET, 1255553);
        assertEquals(1255553, mapper.getBudget(object));
    }

    @Test
    public void testGetReleaseDate() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.RELEASE_DATE, "2015-2-14");
        assertEquals("2015-2-14", mapper.getReleaseDate(object));

    }

    @Test
    public void testGetFirstAirDate() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.FIRST_AIR_DATE, "2013-2-14");
        assertEquals("2013-2-14", mapper.getFirstAirDate(object));
    }

    @Test
    public void testGetPosterPath() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.POSTER_PATH, "/image/path");
        assertEquals("/image/path", mapper.getPosterPath(object));
    }

    @Test
    public void testGetOverview() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.OVERVIEW, "a description");
        assertEquals("a description", mapper.getOverview(object));
    }

    @Test
    public void testGetTitle() throws Exception {
        JsonObject object = getJsonObjectString(ApiConstants.TITLE, "Star Wars");
        assertEquals("Star Wars", mapper.getTitle(object));
    }

    @Test
    public void testConvertToList() throws Exception {
        JsonArray array = getJsonArray(ApiConstants.NAME, "HBO");
        assertEquals(array.size(), mapper.convertToList(array).size());
    }

    @Test
    public void testConvertToList_ShouldHasSizeGreaterThanZero() throws Exception {
        JsonArray array = getJsonArray(ApiConstants.NAME, "HBO");
        assertEquals(1, mapper.convertToList(array).size());
    }

    private JsonObject getJsonObjectLong(String reference, long value) {
        JsonObject object = new JsonObject();
        object.addProperty(reference, value);
        return object;
    }

    private JsonObject getJsonObjectString(String reference, String value) {
        JsonObject object = new JsonObject();
        object.addProperty(reference, value);
        return object;
    }

    private JsonObject getJsonObjectDouble(String reference, double value) {
        JsonObject object = new JsonObject();
        object.addProperty(reference, value);
        return object;
    }


    private JsonObject getJsonObjectInt(String reference, int value) {
        JsonObject object = new JsonObject();
        object.addProperty(reference, value);
        return object;
    }

    private JsonArray getJsonArray(String reference, String value) {
        JsonObject object = new JsonObject();
        object.addProperty(reference, value);
        JsonArray array = new JsonArray();
        array.add(object);
        return array;
    }
}