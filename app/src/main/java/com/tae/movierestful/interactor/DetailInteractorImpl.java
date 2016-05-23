package com.tae.movierestful.interactor;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.api.service.detail.DetailService;
import com.tae.movierestful.data.local.detail.CommonDetail;

import javax.inject.Inject;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class DetailInteractorImpl implements DetailInteractor {

    @Inject
    DetailService detailService;

    @Inject
    public DetailInteractorImpl() {
    }

    @Override
    public void requestService(String type, long id, ApiCallback<CommonDetail, ErrorResponse> callback) {
        detailService.initService(type, id, callback);
    }
}
