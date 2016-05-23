package com.tae.movierestful.data.api.service.category;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.category.CommonCategory;
import com.tae.movierestful.interactor.ApiCallback;

import java.util.List;

/**
 * Created by Eduardo on 18/05/2016.
 */
public interface CategoryService {

    void initService(String categoryType, ApiCallback<List<CommonCategory>, ErrorResponse> callback);

}
