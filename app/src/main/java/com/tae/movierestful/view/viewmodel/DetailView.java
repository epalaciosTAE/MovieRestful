package com.tae.movierestful.view.viewmodel;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.detail.CommonDetail;

/**
 * Created by Eduardo on 19/05/2016.
 */
public interface DetailView extends ViewModel{

    void displayView(CommonDetail commonDetail);
}
