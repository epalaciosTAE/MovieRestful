package com.tae.movierestful.interactor;

/**
 * Created by Eduardo on 18/05/2016.
 */
public interface ApiCallback<R, E> {

    void apiResponse(R response);

    void apiError(E error);
}
