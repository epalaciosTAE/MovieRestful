package com.tae.movierestful.presenter;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.category.CategoryType;
import com.tae.movierestful.data.local.category.CommonCategory;
import com.tae.movierestful.data.local.category.Movie;
import com.tae.movierestful.interactor.ApiCallback;
import com.tae.movierestful.interactor.CategoryInteractor;
import com.tae.movierestful.view.viewmodel.CategoryView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by Eduardo on 21/05/2016.
 */
public class CategoryPresenterImplTest {

    @Mock
    CategoryInteractor interactor;

    @InjectMocks
    CategoryPresenterImpl presenter;

    @Captor
    ArgumentCaptor<ApiCallback<List<CommonCategory>, ErrorResponse>> captor;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

    }

    @Test
    public void requestCategory_shouldBeInvokedOncePerMovie() throws Exception {
        presenter.requestCategory(CategoryType.MOVIE);
        verify(interactor, times(1)).requestService(eq(CategoryType.MOVIE), captor.capture());
    }

    @Test
    public void requestCategory_shouldBeInvokedOncePerSerie() throws Exception {
        presenter.requestCategory(CategoryType.SERIE);
        verify(interactor, times(1)).requestService(eq(CategoryType.SERIE), captor.capture());
    }


    @Test
    public void requestCategory_shouldBeInvokedOncePerCelebrity() throws Exception {
        presenter.requestCategory(CategoryType.CELEBRITY);
        verify(interactor, times(1)).requestService(eq(CategoryType.CELEBRITY), captor.capture());
    }
}