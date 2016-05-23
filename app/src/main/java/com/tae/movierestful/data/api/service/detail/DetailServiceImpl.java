package com.tae.movierestful.data.api.service.detail;

import com.google.gson.JsonObject;
import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.api.service.api.ApiFactory;
import com.tae.movierestful.data.local.detail.CommonDetail;
import com.tae.movierestful.interactor.ApiCallback;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class DetailServiceImpl implements DetailService {

    @Inject
    ApiFactory apiFactory;

    @Inject
    DetailParser parser;

    @Inject
    public DetailServiceImpl() {
    }

    @Override
    public void initService(final String type, long id, ApiCallback<CommonDetail, ErrorResponse> callback) {
        Observable<JsonObject> detailObservable = apiFactory.getDetailService(type, id);
        detailObservable.map(new Func1<JsonObject, CommonDetail>() {
            @Override
            public CommonDetail call(JsonObject jsonObject) {
                return parser.parseResult(type, jsonObject);
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new DetailSubscriber(callback));
    }
}
