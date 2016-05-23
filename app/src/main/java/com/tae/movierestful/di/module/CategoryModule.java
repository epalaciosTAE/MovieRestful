package com.tae.movierestful.di.module;

import com.tae.movierestful.data.api.service.category.CategoryFactory;
import com.tae.movierestful.data.api.service.category.CategoryFactoryImpl;
import com.tae.movierestful.data.api.service.category.CategoryParser;
import com.tae.movierestful.data.api.service.category.CategoryParserImpl;
import com.tae.movierestful.data.api.service.category.CategoryService;
import com.tae.movierestful.data.api.service.category.CategoryServiceImpl;
import com.tae.movierestful.di.ActivityScope;
import com.tae.movierestful.interactor.CategoryInteractor;
import com.tae.movierestful.interactor.CategoryInteractorImpl;
import com.tae.movierestful.presenter.CategoryPresenter;
import com.tae.movierestful.presenter.CategoryPresenterImpl;
import com.tae.movierestful.view.viewmodel.CategoryView;
import com.tae.movierestful.view.activity.ScreenLauncher;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eduardo on 18/05/2016.
 */
@Module
public class CategoryModule {

    private CategoryView view;
    private ScreenLauncher launcher;

    public CategoryModule(CategoryView view, ScreenLauncher launcher) {
        this.view = view;
        this.launcher = launcher;
    }

    @ActivityScope
    @Provides
    public CategoryView provideCategoryView () {
        return view;
    }


    @ActivityScope
    @Provides
    public ScreenLauncher provideScreenLauncher () {
        return launcher;
    }

    @ActivityScope
    @Provides
    public CategoryPresenter provideCategoryPresenter(CategoryPresenterImpl presenter) {
        return presenter;
    }


    @ActivityScope
    @Provides
    public CategoryInteractor provideCategoryInteractor(CategoryInteractorImpl interactor) {
        return interactor;
    }

    @ActivityScope
    @Provides
    public CategoryService provideCategoryService(CategoryServiceImpl categoryService) {
        return categoryService;
    }


    @ActivityScope
    @Provides
    public CategoryParser provideMovieParser(CategoryParserImpl parser) {
        return parser;
    }

    @ActivityScope
    @Provides
    public CategoryFactory provideMovieFactory(CategoryFactoryImpl categoryFactory) {
        return categoryFactory;
    }
}
