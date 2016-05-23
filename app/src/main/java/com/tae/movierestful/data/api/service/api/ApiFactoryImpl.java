package com.tae.movierestful.data.api.service.api;

import com.google.gson.JsonObject;
import com.tae.movierestful.data.local.category.CategoryType;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class ApiFactoryImpl implements ApiFactory {

    @Inject
    ApiService apiService;

    @Inject
    public ApiFactoryImpl() {
    }

    @Override
    public Observable<JsonObject> getCategoryService(String categoryType) {
        Observable<JsonObject> observable = null;
        switch (categoryType) {
            case CategoryType.MOVIE:
                observable = apiService.getPopularMovies();
                break;
            case CategoryType.SERIE:
                observable = apiService.getPopularSeries();
                break;
            case CategoryType.CELEBRITY:
                observable = apiService.getPopularCelebrities();
                break;
        }
        return observable;
    }

    @Override
    public Observable<JsonObject> getDetailService(String type, long id) {
        Observable<JsonObject> observable = null;
        switch (type) {
            case CategoryType.MOVIE:
                observable = apiService.getMovieById(String.valueOf(id));
                break;
            case CategoryType.SERIE:
                observable = apiService.getSerieById(String.valueOf(id));
                break;
            case CategoryType.CELEBRITY:
                observable = apiService.getCelebrityById(String.valueOf(id));
                break;
        }
        return observable;
    }
}
