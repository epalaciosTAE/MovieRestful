package com.tae.movierestful.data.local.category;

import android.support.annotation.Nullable;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class CategoryType {

    public static final String MOVIE = "movie";
    public static final String SERIE = "serie";
    public static final String CELEBRITY = "celebrity";
    public static final String TYPE = "type";

    public static final int MOVIE_ORDINAL = 0;
    public static final int SERIE_ORDINAL = 1;
    public static final int CELEBRITY_ORDINAL = 2;

    @Nullable
    public static String getType(int position) {
        String type = null;
        switch (position) {
            case MOVIE_ORDINAL:
                type = MOVIE;
                break;
            case SERIE_ORDINAL:
                type = SERIE;
                break;
            case CELEBRITY_ORDINAL:
                type = CELEBRITY;
                break;
        }
        return type;
    }

    public static int getType(String type) {
        int typeOrdinal = -1;
        switch (type) {
            case MOVIE:
                typeOrdinal = MOVIE_ORDINAL;
                break;
            case SERIE:
                typeOrdinal = SERIE_ORDINAL;
                break;
            case CELEBRITY:
                typeOrdinal = CELEBRITY_ORDINAL;
                break;
        }
        return typeOrdinal;
    }

}
