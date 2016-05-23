package com.tae.movierestful.utils;

import android.content.Context;

import com.tae.movierestful.R;

import javax.inject.Inject;

import static com.tae.movierestful.data.local.category.CategoryType.MOVIE_ORDINAL;
import static com.tae.movierestful.data.local.category.CategoryType.CELEBRITY_ORDINAL;
import static com.tae.movierestful.data.local.category.CategoryType.SERIE_ORDINAL;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class TitleFactoryImpl implements TitleFactory {

    private Context context;

    @Inject
    public TitleFactoryImpl(Context context) {
        this.context = context;
    }

    public String getTitle(int position) {
        String title = null;
        switch (position) {
            case MOVIE_ORDINAL:
                title = context.getResources().getString(R.string.title_movies);
                break;
            case SERIE_ORDINAL:
                title = context.getResources().getString(R.string.title_series);
                break;
            case CELEBRITY_ORDINAL:
                title = context.getResources().getString(R.string.title_person);
                break;
        }

        return title;
    }
}
