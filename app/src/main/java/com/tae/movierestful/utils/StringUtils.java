package com.tae.movierestful.utils;

import android.support.annotation.NonNull;

import com.tae.movierestful.data.api.constants.ApiConstants;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class StringUtils {

    @NonNull
    public static String buildImagePath(String imagePath) {
        StringBuilder imageBuilder = new StringBuilder();
        imageBuilder.append(ApiConstants.BASE_URL_IMAGE);
        imageBuilder.append(imagePath);
        return imageBuilder.toString();
    }
}
