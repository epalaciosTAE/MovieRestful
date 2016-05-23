package com.tae.movierestful.di.module;

import android.content.Context;

import com.tae.movierestful.utils.TitleFactory;
import com.tae.movierestful.utils.TitleFactoryImpl;
import com.tae.movierestful.view.MovieApp;
import com.tae.movierestful.view.adapter.category.CategoryBinder;
import com.tae.movierestful.view.adapter.category.CategoryBinderImpl;
import com.tae.movierestful.view.fragment.FragmentFactory;
import com.tae.movierestful.view.fragment.FragmentFactoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eduardo on 18/05/2016.
 */
@Module
public class ApplicationModule {

    @Singleton
    @Provides
    Context provideContext() {
        return MovieApp.getInstance();
    }

    @Singleton
    @Provides
    TitleFactory provideTitleFactory(TitleFactoryImpl titleFactory) {
        return titleFactory;
    }

    @Singleton
    @Provides
    FragmentFactory provideFragmentFactory(FragmentFactoryImpl fragmentFactory) {
        return fragmentFactory;
    }

    @Singleton
    @Provides
    CategoryBinder provideMovieBinder(CategoryBinderImpl binder) {
        return binder;
    }
}
