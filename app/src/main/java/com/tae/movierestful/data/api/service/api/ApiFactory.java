package com.tae.movierestful.data.api.service.api;

import com.google.gson.JsonObject;

import rx.Observable;

/**
 * Created by Eduardo on 18/05/2016.
 */
public interface ApiFactory {

    Observable<JsonObject> getCategoryService(String categoryType);
    Observable<JsonObject> getDetailService(String type, long id);
}
