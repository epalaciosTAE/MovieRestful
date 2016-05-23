package com.tae.movierestful.view.viewmodel;

import com.tae.movierestful.data.api.service.ErrorResponse;

/**
 * Created by Eduardo on 19/05/2016.
 */
public interface ViewModel {

    void updateViewOnError(ErrorResponse error);
}
