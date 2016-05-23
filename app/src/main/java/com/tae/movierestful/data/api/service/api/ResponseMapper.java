package com.tae.movierestful.data.api.service.api;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tae.movierestful.data.api.constants.ApiConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class ResponseMapper {

    protected long getId(JsonElement element) {
        return element.getAsJsonObject().get(ApiConstants.ID).getAsLong();
    }

    protected int getGender(JsonObject response) {
        return response.get(ApiConstants.GENDER).getAsInt();
    }

    protected double getPopularity(JsonObject response) {
        return response.get(ApiConstants.POPULARITY).getAsDouble();
    }

    protected String getPlaceOfBirth(JsonObject response) {
        return response.get(ApiConstants.PLACE_OF_BIRTH).getAsString();
    }

    protected String getProfilePath(JsonObject response) {
        return response.get(ApiConstants.PROFILE_PATH).getAsString();
    }

    protected String getDeathday(JsonObject response) {
        return response.get(ApiConstants.DEATHDAY).getAsString();
    }

    protected String getBirthday(JsonObject response) {
        return response.get(ApiConstants.BIRTHDAY).getAsString();
    }

    protected String getBiography(JsonObject response) {
        return response.get(ApiConstants.BIOGRAPHY).getAsString();
    }

    protected int getNumberOfSeasons(JsonObject response) {
        return response.get(ApiConstants.NUMBER_OF_SEASONS).getAsInt();
    }

    protected int getSeasonNumber(JsonElement element) {
        return element.getAsJsonObject().get(ApiConstants.SEASON_NUMBER).getAsInt();
    }

    protected int getEpisodesCount(JsonElement element) {
        return element.getAsJsonObject().get(ApiConstants.EPISODE_COUNT).getAsInt();
    }

    protected JsonArray getSeasons(JsonObject response) {
        return response.get(ApiConstants.SEASONS).getAsJsonArray();
    }

    protected JsonArray getNetworks(JsonObject response) {
        return response.get(ApiConstants.NETWORKS).getAsJsonArray();
    }

    protected String getLastAirDate(JsonObject response) {
        return response.get(ApiConstants.LAST_AIR_DATE).getAsString();
    }

    protected int getNumberOfEpisodes(JsonObject response) {
        return response.get(ApiConstants.NUMBER_OF_EPISODES).getAsInt();
    }

    protected String getName(JsonObject response) {
        return response.get(ApiConstants.NAME).getAsString();
    }

    protected JsonArray getGenres(JsonObject response) {
        return response.get(ApiConstants.GENRES).getAsJsonArray();
    }

    protected int getRuntime(JsonObject response) {
        return response.get(ApiConstants.RUNTIME).getAsInt();
    }

    protected double getVoteAverage(JsonObject response) {
        return response.get(ApiConstants.VOTE_AVERAGE).getAsDouble();
    }

    protected long getBudget(JsonObject response) {
        return response.get(ApiConstants.BUDGET).getAsLong();
    }

    protected String getReleaseDate(JsonObject response) {
        return response.get(ApiConstants.RELEASE_DATE).getAsString();
    }

    protected String getFirstAirDate(JsonObject response) {
        return response.get(ApiConstants.FIRST_AIR_DATE).getAsString();
    }

    protected JsonArray getProductionCompanies(JsonObject response) {
        return response.get(ApiConstants.PRODUCTION_COMPANIES).getAsJsonArray();
    }

    protected String getPosterPath(JsonObject response) {
        return response.get(ApiConstants.POSTER_PATH).getAsString();
    }

    protected String getOverview(JsonObject response) {
        return response.get(ApiConstants.OVERVIEW).getAsString();
    }

    protected String getTitle(JsonObject response) {
        return response.get(ApiConstants.TITLE).getAsString();
    }

    @NonNull
    protected <T> List<T> convertToList(JsonArray jsonArray) {
        List<T> list = new ArrayList<>(jsonArray.size());
        for (JsonElement element : jsonArray) {
            list.add((T) getName(element.getAsJsonObject()));
        }
        return list;
    }

}
