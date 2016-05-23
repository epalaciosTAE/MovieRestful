package com.tae.movierestful.data.api.service.api;

import com.google.gson.JsonObject;
import com.tae.movierestful.data.api.constants.ApiConstants;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Eduardo on 18/05/2016.
 */
public interface ApiService {

    @GET(ApiConstants.MOVIES_POPULAR)
    Observable<JsonObject> getPopularMovies();

    @GET(ApiConstants.SERIES_POPULAR)
    Observable<JsonObject> getPopularSeries();

    @GET(ApiConstants.CELEBRITIES_POPULAR)
    Observable<JsonObject> getPopularCelebrities();

    @GET(ApiConstants.MOVIE_BY_ID)
    Observable<JsonObject> getMovieById(@Path(ApiConstants.ID) String id);

    @GET(ApiConstants.SERIE_BY_ID)
    Observable<JsonObject> getSerieById(@Path(ApiConstants.ID) String id);

    @GET(ApiConstants.CELEBRITY_BY_ID)
    Observable<JsonObject> getCelebrityById(@Path(ApiConstants.ID) String id);
}
