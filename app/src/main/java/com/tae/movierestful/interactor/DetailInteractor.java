package com.tae.movierestful.interactor;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.detail.CommonDetail;

/**
 * Created by Eduardo on 19/05/2016.
 */
public interface DetailInteractor {

    void requestService(String type,long id, ApiCallback<CommonDetail, ErrorResponse> callback);
}
