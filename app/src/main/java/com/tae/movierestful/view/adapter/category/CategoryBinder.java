package com.tae.movierestful.view.adapter.category;

import com.tae.movierestful.data.local.category.CommonCategory;

import java.util.List;

/**
 * Created by Eduardo on 19/05/2016.
 */
public interface CategoryBinder {

    void bind(CategoryAdapter.ViewHolder holder, int position, int type, List<CommonCategory> categoryList);

}
