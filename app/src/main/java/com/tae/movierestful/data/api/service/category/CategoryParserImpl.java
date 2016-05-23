package com.tae.movierestful.data.api.service.category;

import com.google.gson.JsonArray;
import com.tae.movierestful.data.local.category.CategoryType;
import com.tae.movierestful.data.local.category.CommonCategory;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class CategoryParserImpl implements CategoryParser {

    @Inject
    CategoryFactory categoryFactory;

    @Inject
    public CategoryParserImpl() {
    }

    @Override
    public List<CommonCategory> parseResults(String categoryType, JsonArray results) {
        List<CommonCategory> categories = null;
        switch (categoryType) {
            case CategoryType.MOVIE:
            case CategoryType.SERIE:
                categories = categoryFactory.createMovie(categoryType, results);
                break;
            case CategoryType.CELEBRITY:
                categories = categoryFactory.createCelebrity(results);
                break;
        }
        return categories;
    }
}
