package com.tae.movierestful.data.api.service;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class ErrorResponse {
    private String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
