package com.tae.movierestful.interactor;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.api.service.category.CategoryService;
import com.tae.movierestful.data.local.category.CommonCategory;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class CategoryInteractorImpl implements CategoryInteractor {

    @Inject
    CategoryService categoryService;

    @Inject
    public CategoryInteractorImpl() {
    }

    @Override
    public void requestService(String categoryType, ApiCallback<List<CommonCategory>, ErrorResponse> callback) {
        categoryService.initService(categoryType, callback);
    }


}
