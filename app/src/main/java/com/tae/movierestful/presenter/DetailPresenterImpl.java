package com.tae.movierestful.presenter;

import android.view.View;

import com.tae.movierestful.R;
import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.category.CategoryType;
import com.tae.movierestful.data.local.detail.CelebrityDetail;
import com.tae.movierestful.data.local.detail.CommonDetail;
import com.tae.movierestful.data.local.detail.MovieDetail;
import com.tae.movierestful.data.local.detail.SerieDetail;
import com.tae.movierestful.interactor.ApiCallback;
import com.tae.movierestful.interactor.DetailInteractor;
import com.tae.movierestful.view.viewmodel.DetailView;

import javax.inject.Inject;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class DetailPresenterImpl implements DetailPresenter {

    @Inject
    DetailView view;
    @Inject
    DetailInteractor interactor;

    @Inject
    public DetailPresenterImpl() {
    }

    @Override
    public void requestDetail(String type, long id) {
        interactor.requestService(type, id, new ApiCallback<CommonDetail, ErrorResponse>() {
            @Override
            public void apiResponse(CommonDetail response) {
                view.displayView(response);
            }

            @Override
            public void apiError(ErrorResponse error) {
                view.updateViewOnError(error);
            }
        });
    }
}
