package com.tae.movierestful.data.api.service.category;

import com.google.gson.JsonObject;

import rx.Observable;

/**
 * Created by Eduardo on 20/05/2016.
 */
public class ObservableFake {

    private Observable<JsonObject> categoryObservable;

    public Observable<JsonObject> getCategoryObservable() {
        return categoryObservable;
    }

    public void setCategoryObservable(Observable<JsonObject> categoryObservable) {
        this.categoryObservable = categoryObservable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObservableFake that = (ObservableFake) o;

        return getCategoryObservable() != null ? getCategoryObservable().equals(that.getCategoryObservable()) : that.getCategoryObservable() == null;

    }

    @Override
    public int hashCode() {
        return getCategoryObservable() != null ? getCategoryObservable().hashCode() : 0;
    }
}
