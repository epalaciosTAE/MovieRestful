package com.tae.movierestful.data.api.service.category;

import com.google.gson.JsonArray;
import com.tae.movierestful.data.local.category.CommonCategory;

import java.util.List;

/**
 * Created by Eduardo on 19/05/2016.
 */
public interface CategoryParser {

    List<CommonCategory> parseResults(String categoryType, JsonArray results);
}
