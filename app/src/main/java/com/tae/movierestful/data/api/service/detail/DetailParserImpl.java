package com.tae.movierestful.data.api.service.detail;

import com.google.gson.JsonObject;
import com.tae.movierestful.data.local.category.CategoryType;
import com.tae.movierestful.data.local.detail.CommonDetail;

import javax.inject.Inject;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class DetailParserImpl implements DetailParser {

    @Inject
    DetailFactory detailFactory;

    @Inject
    public DetailParserImpl() {
    }

    @Override
    public CommonDetail parseResult(String type, JsonObject response) {
        CommonDetail commonDetail = null;
        switch (type) {
            case CategoryType.MOVIE:
                commonDetail = detailFactory.createMovieDetail(response);
                break;
            case CategoryType.SERIE:
                commonDetail = detailFactory.createSerieDetail(response);
                break;
            case CategoryType.CELEBRITY:
                commonDetail = detailFactory.createCelebrityDetail(response);
                break;
        }
        return commonDetail;
    }
}
