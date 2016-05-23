package com.tae.movierestful.view.adapter.detail;

import android.view.View;

import com.tae.movierestful.data.local.detail.CelebrityDetail;
import com.tae.movierestful.data.local.detail.CommonDetail;
import com.tae.movierestful.data.local.detail.MovieDetail;
import com.tae.movierestful.data.local.detail.SerieDetail;

/**
 * Created by Eduardo on 19/05/2016.
 */
public interface DetailBinder {

    void bindMovieDetail(MovieDetail movieDetail, View view);

    void bindSerieDetail(SerieDetail serieDetail, View view);

    void bindCelebrityDetail(CelebrityDetail celebrityDetail, View view);

}
