package com.tae.movierestful.data.api.service.detail;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.detail.CommonDetail;
import com.tae.movierestful.interactor.ApiCallback;

import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class DetailSubscriber extends Subscriber<CommonDetail>{

    private ApiCallback<CommonDetail, ErrorResponse> callback;

    public DetailSubscriber(ApiCallback<CommonDetail, ErrorResponse> callback) {
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
    public void onNext(CommonDetail commonDetail) {
        callback.apiResponse(commonDetail);
    }
}
