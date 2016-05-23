package com.tae.movierestful.data.api.service.category;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tae.movierestful.data.api.constants.ApiConstants;
import com.tae.movierestful.data.api.service.api.ApiFactory;
import com.tae.movierestful.data.local.category.CategoryType;
import com.tae.movierestful.data.local.category.CommonCategory;
import com.tae.movierestful.data.local.category.Movie;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by Eduardo on 20/05/2016.
 */
public class CategoryServiceImplTest {

    @Mock
    ApiFactory apiFactory;

    @Mock
    CategoryParser parser;

    private JsonObject apiResult;
    private JsonObject jsonProperty;
    private JsonArray jsonResults;
    private List<CommonCategory> categories;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        jsonProperty = createJsonProperty();
        jsonResults = createJsonResults();
        apiResult = createResult();
        categories = createCommonCategories();
    }

    @Test
    public void service_ShouldReturnMovie() throws Exception {
        mockServiceApiResponse();

    }

    @Test
    public void parser_ShouldReturnExpectedValue() throws Exception {
        TestSubscriber<JsonObject> testSubscriber = mockServiceApiResponse();

        when(parser.parseResults(CategoryType.MOVIE, jsonResults)).thenReturn(categories);

        Movie movie = new Movie();
        movie.setId(11223);
        movie.setTitle("Star Wars");

        List<JsonObject> onNextEvents = testSubscriber.getOnNextEvents();
        for (JsonObject onNextEvent : onNextEvents) {
            JsonArray array = onNextEvent.getAsJsonArray(ApiConstants.RESULTS);
            List<CommonCategory> commonCategories = parser.parseResults(CategoryType.MOVIE, array);
            assertNotNull(commonCategories);
            assertTrue(commonCategories.size() > 0);
            Movie movieResult = (Movie) commonCategories.get(0);
            assertEquals(movie, movieResult);
            assertEquals(jsonProperty.get(ApiConstants.ID).getAsLong(), movieResult.getId());
            assertEquals(jsonProperty.get(ApiConstants.TITLE).getAsString(), movieResult.getTitle());
        }
    }

    @Test
    public void apiFactory_ShouldBeInvokedOnce() throws Exception {
        apiFactory.getCategoryService(CategoryType.MOVIE);
        verify(apiFactory, times(1)).getCategoryService(CategoryType.MOVIE);
        verify(apiFactory, times(0)).getDetailService(CategoryType.MOVIE, -1);
    }

    @Test
    public void categoryParser_ShouldBeInvodedOnce() throws Exception {
        parser.parseResults(CategoryType.MOVIE, jsonResults);
        verify(parser, times(1)).parseResults(CategoryType.MOVIE, jsonResults);
    }

    @NonNull
    private TestSubscriber<JsonObject> mockServiceApiResponse() {
        when(apiFactory.getCategoryService(CategoryType.MOVIE)).thenReturn(Observable.just(apiResult));

        Observable<JsonObject> observable = apiFactory.getCategoryService(CategoryType.MOVIE);
        TestSubscriber<JsonObject> testSubscriber = new TestSubscriber<>();
        observable.subscribe(testSubscriber);
        assertNotNull(observable);
        testSubscriber.assertNoErrors();
        return testSubscriber;
    }


    @NonNull
    private List<CommonCategory> createCommonCategories() {
        Movie movie = new Movie();
        movie.setId(11223);
        movie.setTitle("Star Wars");
        List<CommonCategory> categories = new ArrayList<>(1);
        categories.add(movie);
        return categories;
    }

    private JsonObject createResult() {
        JsonObject apiResult = new JsonObject();
        apiResult.add(ApiConstants.RESULTS, jsonResults);
        return apiResult;
    }

    @NonNull
    private JsonObject createJsonProperty() {
        JsonObject jsonProperty = new JsonObject();
        jsonProperty.addProperty(ApiConstants.ID, 11223);
        jsonProperty.addProperty(ApiConstants.TITLE, "Star Wars");
        return jsonProperty;
    }

    private JsonArray createJsonResults() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(jsonProperty);
        return jsonArray;
    }
}