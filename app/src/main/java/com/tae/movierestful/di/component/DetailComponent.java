package com.tae.movierestful.di.component;

import com.tae.movierestful.di.ActivityScope;
import com.tae.movierestful.di.module.DetailModule;
import com.tae.movierestful.view.activity.DetailActivity;

import dagger.Component;

/**
 * Created by Eduardo on 19/05/2016.
 */
@ActivityScope
@Component(modules = DetailModule.class, dependencies = ApplicationComponent.class)
public interface DetailComponent {
    void inject(DetailActivity activity);
}
