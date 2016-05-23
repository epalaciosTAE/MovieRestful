package com.tae.movierestful.view;

import android.app.Application;

import com.tae.movierestful.di.component.ApplicationComponent;
import com.tae.movierestful.di.component.DaggerApplicationComponent;
import com.tae.movierestful.di.module.ApplicationModule;
import com.tae.movierestful.di.module.NetworkModule;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class MovieApp extends Application {

    private static MovieApp instance;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .networkModule(new NetworkModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static MovieApp getInstance() {
        return instance;
    }
}
