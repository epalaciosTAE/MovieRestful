package com.tae.movierestful.data.api.service.category;


import android.support.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tae.movierestful.data.api.constants.ApiConstants;
import com.tae.movierestful.data.api.service.api.ApiFactory;
import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.category.CommonCategory;
import com.tae.movierestful.interactor.ApiCallback;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class CategoryServiceImpl implements CategoryService {

    @Inject
    ApiFactory apiFactory;

    @Inject
    CategoryParser parser;

    @Inject
    public CategoryServiceImpl() {
    }

    @Override
    public void initService(final String categoryType, final ApiCallback<List<CommonCategory>, ErrorResponse> callback) {
        Observable<JsonObject> categoryObservable = apiFactory.getCategoryService(categoryType);
        categoryObservable.map(new Func1<JsonObject, CategoryResponse<CommonCategory>>() {
            @Override
            public CategoryResponse<CommonCategory> call(JsonObject jsonObject) {
                return mapResponse(jsonObject, categoryType);
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new CategorySubscriber(callback));
    }

    @NonNull
    private CategoryResponse<CommonCategory> mapResponse(JsonObject jsonObject, String categoryType) {
        JsonArray jsonArray = jsonObject.getAsJsonArray(ApiConstants.RESULTS);
        CategoryResponse<CommonCategory> response = new CategoryResponse<>();
        List<CommonCategory> results = parser.parseResults(categoryType, jsonArray);
        response.setResults(results);
        return response;
    }

}
