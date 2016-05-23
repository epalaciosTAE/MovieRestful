package com.tae.movierestful.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tae.movierestful.R;
import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.category.CategoryType;
import com.tae.movierestful.data.local.constants.LocalConstans;
import com.tae.movierestful.data.local.detail.CelebrityDetail;
import com.tae.movierestful.data.local.detail.CommonDetail;
import com.tae.movierestful.data.local.detail.MovieDetail;
import com.tae.movierestful.data.local.detail.SerieDetail;
import com.tae.movierestful.di.component.DaggerDetailComponent;
import com.tae.movierestful.di.module.DetailModule;
import com.tae.movierestful.presenter.DetailPresenter;
import com.tae.movierestful.view.MovieApp;
import com.tae.movierestful.view.adapter.detail.DetailBinder;
import com.tae.movierestful.view.viewmodel.DetailView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class DetailActivity extends AppCompatActivity implements DetailView{

    @Inject
    DetailPresenter presenter;
    @Inject
    DetailBinder binder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resolveDependencies();
        requestDetail();
        setContentView(R.layout.empty);
    }

    @Override
    public void displayView(CommonDetail commonDetail) {
        View view = null;
        switch (commonDetail.getType()) {
            case CategoryType.MOVIE:
                view = inflateLayout(R.layout.content_detail_movie);
                MovieDetail movie = (MovieDetail) commonDetail;
                binder.bindMovieDetail(movie, view);
                break;
            case CategoryType.SERIE:
                view = inflateLayout(R.layout.content_detail_serie);
                SerieDetail serie = (SerieDetail) commonDetail;
                binder.bindSerieDetail(serie, view);
                break;
            case CategoryType.CELEBRITY:
                view = inflateLayout(R.layout.content_detail_celebrity);
                CelebrityDetail celebrity = (CelebrityDetail) commonDetail;
                binder.bindCelebrityDetail(celebrity, view);
                break;
        }
        setContentView(view);
    }

    @Override
    public void updateViewOnError(ErrorResponse error) {
        Log.e("ERROR ACTIVIRY DETAIL", "updateViewOnError: " + error.getError());
        Toast.makeText(this, "Error: " + error.getError(), Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private void requestDetail() {
        long id = getIntent().getLongExtra(LocalConstans.EXTRA_ID, -1);
        String type = getIntent().getStringExtra(LocalConstans.EXTRA_TYPE);
        presenter.requestDetail(type, id);
    }

    private void resolveDependencies() {
        DaggerDetailComponent.builder()
                .applicationComponent(MovieApp.getInstance().getApplicationComponent())
                .detailModule(new DetailModule(this))
                .build()
                .inject(this);
    }

    private View inflateLayout(int layout) {
        return getLayoutInflater().inflate(layout, null, false);
    }
}
