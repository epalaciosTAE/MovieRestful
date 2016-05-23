package com.tae.movierestful.view.adapter.category;

import android.support.annotation.NonNull;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.tae.movierestful.R;
import com.tae.movierestful.data.api.constants.ApiConstants;
import com.tae.movierestful.data.local.category.CategoryType;
import com.tae.movierestful.data.local.category.Celebrity;
import com.tae.movierestful.data.local.category.CommonCategory;
import com.tae.movierestful.data.local.category.Movie;
import com.tae.movierestful.utils.StringUtils;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class CategoryBinderImpl implements CategoryBinder {

    @Inject
    public CategoryBinderImpl() {
    }

    @Override
    public void bind(CategoryAdapter.ViewHolder holder, int position, int type, List<CommonCategory> categoryList) {
        if (type != CategoryType.CELEBRITY_ORDINAL) {
            bindMovie(holder, position, categoryList);
        } else {
            bindCelebrity(holder, position, categoryList);
        }
    }

    private void bindMovie(CategoryAdapter.ViewHolder holder, int position, List<CommonCategory> categoryList) {
        Movie movie = (Movie) categoryList.get(position);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvRating.setText(String.valueOf(movie.getRating()));
        holder.tvReleaseDate.setText(movie.getReleaseDate());
        holder.tvDescription.setText(movie.getDescription());
        Picasso.with(holder.itemView.getContext()).load(StringUtils.buildImagePath(movie.getImage()))
                .placeholder(R.drawable.ic_no_image).into(holder.imageView);
    }

    private void bindCelebrity(CategoryAdapter.ViewHolder holder, int position, List<CommonCategory> categoryList) {
        Celebrity celebrity = (Celebrity) categoryList.get(position);
        holder.tvTitle.setText(celebrity.getTitle());
        holder.tvDescription.setText(celebrity.getDescription());
        Picasso.with(holder.itemView.getContext()).load(StringUtils.buildImagePath(celebrity.getImage()))
                .placeholder(R.drawable.ic_no_image).into(holder.imageView);
        holder.tvRating.setVisibility(View.GONE);
        holder.tvReleaseDate.setVisibility(View.GONE);
    }

}
