package com.tae.movierestful.di.component;

import com.tae.movierestful.data.api.service.api.ApiFactory;
import com.tae.movierestful.di.module.ApplicationModule;
import com.tae.movierestful.di.module.NetworkModule;
import com.tae.movierestful.view.activity.MainActivity;
import com.tae.movierestful.view.adapter.category.CategoryPagerAdapter;
import com.tae.movierestful.view.adapter.category.CategoryBinder;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Eduardo on 18/05/2016.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(CategoryPagerAdapter adapter);

    void inject(MainActivity activity);

    CategoryBinder getMovieBinder();

    ApiFactory getApiFactory();

}
