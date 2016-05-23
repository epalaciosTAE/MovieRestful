package com.tae.movierestful.data.api.service.api;

import com.google.gson.JsonObject;
import com.tae.movierestful.data.local.category.CategoryType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import rx.Observable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by Eduardo on 21/05/2016.
 */
public class ApiFactoryImplTest {

    @Mock
    ApiService service;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldReturnObservableMovie() throws Exception {
        when(service.getPopularMovies()).thenReturn(Observable.just(new JsonObject()));
        Observable<JsonObject> jsonObjectObservable = service.getPopularMovies();
        verify(service, times(1)).getPopularMovies();
        assertNotNull(jsonObjectObservable);
    }

    @Test
    public void shouldReturnObservableSerie() throws Exception {
        when(service.getPopularSeries()).thenReturn(Observable.just(new JsonObject()));
        Observable<JsonObject> jsonObjectObservable = service.getPopularSeries();
        verify(service, times(1)).getPopularSeries();
        assertNotNull(jsonObjectObservable);
    }

    @Test
    public void shouldReturnObservableCelebrity() throws Exception {
        when(service.getPopularCelebrities()).thenReturn(Observable.just(new JsonObject()));
        Observable<JsonObject> jsonObjectObservable = service.getPopularCelebrities();
        verify(service, times(1)).getPopularCelebrities();
        assertNotNull(jsonObjectObservable);
    }

    @Test
    public void shouldReturnObservableMovieId() throws Exception {
        when(service.getMovieById("1122")).thenReturn(Observable.just(new JsonObject()));
        Observable<JsonObject> jsonObjectObservable = service.getMovieById("1122");
        verify(service, times(1)).getMovieById("1122");
        assertNotNull(jsonObjectObservable);
    }

    @Test
    public void shouldReturnObservableSerieId() throws Exception {
        when(service.getSerieById("1122")).thenReturn(Observable.just(new JsonObject()));
        Observable<JsonObject> jsonObjectObservable = service.getSerieById("1122");
        verify(service, times(1)).getSerieById("1122");
        assertNotNull(jsonObjectObservable);
    }

    @Test
    public void shouldReturnObservableCelebrityId() throws Exception {
        when(service.getCelebrityById("1122")).thenReturn(Observable.just(new JsonObject()));
        Observable<JsonObject> jsonObjectObservable = service.getCelebrityById("1122");
        verify(service, times(1)).getCelebrityById("1122");
        assertNotNull(jsonObjectObservable);
    }
}