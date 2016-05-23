package com.tae.movierestful.presenter;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.category.CommonCategory;
import com.tae.movierestful.interactor.ApiCallback;
import com.tae.movierestful.interactor.CategoryInteractor;
import com.tae.movierestful.view.viewmodel.CategoryView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class CategoryPresenterImpl implements CategoryPresenter {

    @Inject
    CategoryInteractor interactor;
    @Inject
    CategoryView view;


    @Inject
    public CategoryPresenterImpl() {
    }

    @Override
    public void requestCategory(String categoryType) {
        interactor.requestService(categoryType, new ApiCallback<List<CommonCategory>, ErrorResponse>() {
            @Override
            public void apiResponse(List<CommonCategory> categories) {
                view.updateView(categories);
            }

            @Override
            public void apiError(ErrorResponse error) {
                view.updateViewOnError(error);
            }
        });
    }

}
