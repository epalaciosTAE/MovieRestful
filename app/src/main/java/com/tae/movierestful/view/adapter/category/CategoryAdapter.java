package com.tae.movierestful.view.adapter.category;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tae.movierestful.R;
import com.tae.movierestful.data.local.category.CategoryType;
import com.tae.movierestful.data.local.category.CommonCategory;
import com.tae.movierestful.view.activity.ScreenLauncher;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    @Inject
    CategoryBinder binder;

    @Inject
    ScreenLauncher launcher;

    private List<CommonCategory> categoryList;

    @Inject
    public CategoryAdapter() {
        categoryList = Collections.EMPTY_LIST;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        binder.bind(holder, position, getItemViewType(position), categoryList);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return CategoryType.getType(categoryList.get(position).getType());
    }

    public void updateItems(List<CommonCategory> freshItems) {
        categoryList = freshItems;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.imageDetail)
        ImageView imageView;
        @Bind(R.id.title)
        TextView tvTitle;
        @Bind(R.id.rating)
        TextView tvRating;
        @Bind(R.id.releaseDate)
        TextView tvReleaseDate;
        @Bind(R.id.description)
        TextView tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.moreInfo)
        void onClick(View view) {
            launcher.launchDetailScreen(
                    categoryList.get(getAdapterPosition()).getId(),
                    categoryList.get(getAdapterPosition()).getType());
        }
    }
}
