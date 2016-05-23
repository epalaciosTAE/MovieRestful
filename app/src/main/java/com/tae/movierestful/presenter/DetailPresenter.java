package com.tae.movierestful.presenter;

import android.view.View;

import com.tae.movierestful.data.local.detail.CommonDetail;

/**
 * Created by Eduardo on 19/05/2016.
 */
public interface DetailPresenter {

    void requestDetail(String type, long id);

}
