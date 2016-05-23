package com.tae.movierestful.di.module;

import com.tae.movierestful.data.api.service.detail.DetailFactory;
import com.tae.movierestful.data.api.service.detail.DetailFactoryImpl;
import com.tae.movierestful.data.api.service.detail.DetailParser;
import com.tae.movierestful.data.api.service.detail.DetailParserImpl;
import com.tae.movierestful.data.api.service.detail.DetailService;
import com.tae.movierestful.data.api.service.detail.DetailServiceImpl;
import com.tae.movierestful.di.ActivityScope;
import com.tae.movierestful.interactor.DetailInteractor;
import com.tae.movierestful.interactor.DetailInteractorImpl;
import com.tae.movierestful.presenter.DetailPresenter;
import com.tae.movierestful.presenter.DetailPresenterImpl;
import com.tae.movierestful.view.adapter.detail.DetailBinder;
import com.tae.movierestful.view.adapter.detail.DetailBinderImpl;
import com.tae.movierestful.view.viewmodel.DetailView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eduardo on 19/05/2016.
 */
@Module
public class DetailModule {

    private DetailView view;

    public DetailModule(DetailView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    DetailView provideDetailView() {
        return view;
    }

    @ActivityScope
    @Provides
    DetailPresenter provideDetailPresenter(DetailPresenterImpl presenter) {
        return presenter;
    }

    @ActivityScope
    @Provides
    DetailInteractor provideDetailInteractor(DetailInteractorImpl interactor) {
        return interactor;
    }

    @ActivityScope
    @Provides
    DetailService provideDetailService(DetailServiceImpl detailService) {
        return detailService;
    }

    @ActivityScope
    @Provides
    public DetailParser provideDetailParser(DetailParserImpl parser) {
        return parser;
    }

    @ActivityScope
    @Provides
    public DetailFactory provideDetailFactory(DetailFactoryImpl detailFactory) {
        return detailFactory;
    }

    @ActivityScope
    @Provides
    public DetailBinder provideDetailBinder(DetailBinderImpl detailBinder) {
        return detailBinder;
    }

}
