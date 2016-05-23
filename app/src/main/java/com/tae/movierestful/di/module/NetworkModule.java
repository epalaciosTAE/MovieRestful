package com.tae.movierestful.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tae.movierestful.data.api.constants.ApiConstants;
import com.tae.movierestful.data.api.service.api.ApiFactory;
import com.tae.movierestful.data.api.service.api.ApiFactoryImpl;
import com.tae.movierestful.data.api.service.api.ApiService;
import com.tae.movierestful.data.api.service.category.CategoryFactory;
import com.tae.movierestful.data.api.service.category.CategoryFactoryImpl;
import com.tae.movierestful.data.api.service.category.CategoryParserImpl;
import com.tae.movierestful.data.api.service.category.CategoryService;
import com.tae.movierestful.data.api.service.category.CategoryServiceImpl;
import com.tae.movierestful.data.api.service.category.CategoryParser;
import com.tae.movierestful.data.api.service.detail.DetailFactory;
import com.tae.movierestful.data.api.service.detail.DetailFactoryImpl;
import com.tae.movierestful.data.api.service.detail.DetailParser;
import com.tae.movierestful.data.api.service.detail.DetailParserImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by Eduardo on 18/05/2016.
 */
@Module
public class NetworkModule {

    @Singleton
    @Provides
    ApiService providesApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    @Singleton
    @Provides
    public Gson providesGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.create();
    }

    @Singleton
    @Provides
    public OkHttpClient providesOkHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Singleton
    @Provides
    public HttpLoggingInterceptor providesInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Singleton
    @Provides
    public ApiFactory provideApiFactory(ApiFactoryImpl apiFactory) {
        return apiFactory;
    }


}
