package com.tae.movierestful.interactor;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.category.CommonCategory;

import java.util.List;

/**
 * Created by Eduardo on 18/05/2016.
 */
public interface CategoryInteractor {

    void requestService(String categoryType, ApiCallback<List<CommonCategory>, ErrorResponse> callback);
}
