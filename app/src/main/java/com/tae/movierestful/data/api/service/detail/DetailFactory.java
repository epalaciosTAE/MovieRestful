package com.tae.movierestful.data.api.service.detail;

import com.google.gson.JsonObject;
import com.tae.movierestful.data.local.detail.CommonDetail;

/**
 * Created by Eduardo on 19/05/2016.
 */
public interface DetailFactory {

    CommonDetail createMovieDetail(JsonObject response);
    CommonDetail createSerieDetail(JsonObject response);
    CommonDetail createCelebrityDetail(JsonObject response);
}
