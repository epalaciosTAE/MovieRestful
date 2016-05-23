package com.tae.movierestful.data.api.service.detail;

import com.google.gson.JsonObject;
import com.tae.movierestful.data.local.detail.CommonDetail;

/**
 * Created by Eduardo on 19/05/2016.
 */
public interface DetailParser {

    CommonDetail parseResult(String type, JsonObject jsonObject);
}
