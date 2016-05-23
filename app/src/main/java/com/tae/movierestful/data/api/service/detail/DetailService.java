package com.tae.movierestful.data.api.service.detail;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.detail.CommonDetail;
import com.tae.movierestful.interactor.ApiCallback;

/**
 * Created by Eduardo on 19/05/2016.
 */
public interface DetailService {

    void initService(String type, long id, ApiCallback<CommonDetail, ErrorResponse> callback);
}
