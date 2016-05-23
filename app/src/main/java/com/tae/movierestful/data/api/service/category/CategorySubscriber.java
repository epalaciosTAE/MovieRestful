package com.tae.movierestful.data.api.service.category;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.category.CommonCategory;
import com.tae.movierestful.interactor.ApiCallback;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class CategorySubscriber extends Subscriber<CategoryResponse<CommonCategory>> {

    private ApiCallback<List<CommonCategory>, ErrorResponse> callback;

    public CategorySubscriber(ApiCallback<List<CommonCategory>, ErrorResponse> callback) {
        this.callback = callback;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        callback.apiError(new ErrorResponse(e.getMessage()));
    }

    @Override
    public void onNext(CategoryResponse<CommonCategory> response) {
        callback.apiResponse(response.getResults());
    }

}
