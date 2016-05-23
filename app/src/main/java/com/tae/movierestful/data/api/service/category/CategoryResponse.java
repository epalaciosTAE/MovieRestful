package com.tae.movierestful.data.api.service.category;

import java.util.List;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class CategoryResponse<T> {

    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
