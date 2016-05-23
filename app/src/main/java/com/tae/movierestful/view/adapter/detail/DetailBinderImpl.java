package com.tae.movierestful.view.adapter.detail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tae.movierestful.R;
import com.tae.movierestful.data.local.detail.CelebrityDetail;
import com.tae.movierestful.data.local.detail.CommonDetail;
import com.tae.movierestful.data.local.detail.MovieDetail;
import com.tae.movierestful.data.local.detail.SerieDetail;
import com.tae.movierestful.utils.StringUtils;
import com.tae.movierestful.view.widgets.ImageViewDetail;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class DetailBinderImpl implements DetailBinder {

    @Inject
    public DetailBinderImpl() {
    }

    @Override
    public void bindMovieDetail(MovieDetail movie, View view) {
        TextView tvTitle = (TextView) findView(view, R.id.tvDetailTitle);
        TextView tvReleaseDate = (TextView) findView(view, R.id.tvReleaseDateDetail);
        TextView tvRating = (TextView) findView(view, R.id.tvRating);
        TextView tvBudget = (TextView) findView(view, R.id.tvBudget);
        TextView tvRunTime = (TextView) findView(view, R.id.tvRunTimeDetail);
        TextView tvDescription = (TextView) findView(view, R.id.tvDescriptionDetail);
        ImageViewDetail imageView = (ImageViewDetail) findView(view, R.id.imageDetail);

        tvTitle.setText(movie.getTitle());
        tvReleaseDate.setText(movie.getReleaseDate());
        tvRating.setText(String.valueOf(movie.getRating()));
        tvBudget.setText(String.valueOf(movie.getBudget() + " $"));
        String runtime = buildRuntime(movie, view);
        tvRunTime.setText(runtime);
        tvDescription.setText(movie.getDescription());

        setPicassoImage(movie.getImage(), view, imageView);
    }

    @Override
    public void bindSerieDetail(SerieDetail serie, View view) {
        ImageView imageView = (ImageView) findView(view, R.id.imageDetail);
        TextView tvName = (TextView) findView(view, R.id.tvDetailName);
        TextView tvLastEpisodeDate = (TextView) findView(view, R.id.tvLastEpisodeDate);
        TextView tvRating = (TextView) findView(view, R.id.tvRating);
        TextView tvSeasons = (TextView) findView(view, R.id.tvSeasons);
        TextView tvNetwork = (TextView) findView(view, R.id.tvNetwork);
        TextView tvDescriptionDetail = (TextView) findView(view, R.id.tvDescriptionDetail);

        tvName.setText(serie.getName());
        tvLastEpisodeDate.setText(serie.getLastEpisodeDate());
        tvRating.setText(String.valueOf(serie.getRating()));
        tvSeasons.setText(buildSeasonTotal(serie, view));
        tvNetwork.setText(serie.getNetworks().get(0));
        tvDescriptionDetail.setText(serie.getDescription());

        setPicassoImage(serie.getImage(), view, imageView);
        }

    private String buildSeasonTotal(SerieDetail serie, View view) {
        StringBuilder seasonbuilder = new StringBuilder();
        seasonbuilder.append(getStringResource(view, R.string.numberOfSeasons));
        seasonbuilder.append(" ");
        seasonbuilder.append(String.valueOf(serie.getSeasonTotal()));
        return seasonbuilder.toString();
    }

    @Override
    public void bindCelebrityDetail(CelebrityDetail celebrity, View view) {
        ImageView imageView = (ImageView) findView(view, R.id.imageDetail);
        TextView tvName = (TextView) findView(view, R.id.tvDetailName);
        TextView tvBirthdayDetail = (TextView) findView(view, R.id.tvBirthdayDetail);
        TextView tvPopularity = (TextView) findView(view, R.id.tvPopularity);
        TextView tvBiographyDetail = (TextView) findView(view, R.id.tvBiographyDetail);

        tvName.setText(celebrity.getName());
        tvBirthdayDetail.setText(celebrity.getBirthday());
        tvPopularity.setText(String.valueOf(celebrity.getPopularity()));
        tvBiographyDetail.setText(celebrity.getBiography());

        setPicassoImage(celebrity.getImage(), view, imageView);
    }

    private void setPicassoImage(String image, View view, ImageView imageView) {
        Picasso.with(view.getContext())
                .load(StringUtils.buildImagePath(image))
                .fit()
                .error(R.drawable.ic_no_image)
                .into(imageView);
    }

    @NonNull
    private String buildRuntime(MovieDetail movieDetail, View view) {
        StringBuilder builder = new StringBuilder();
        builder.append(movieDetail.getRunTime());
        builder.append(getStringResource(view, R.string.min));
        return builder.toString();
    }

    @NonNull
    private String getStringResource(View view, int resourceId) {
        return view.getContext().getResources().getString(resourceId);
    }

    private View findView(View view, int childView) {
        return ButterKnife.findById(view, childView);
    }

}
