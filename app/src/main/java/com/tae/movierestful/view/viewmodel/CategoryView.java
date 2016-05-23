package com.tae.movierestful.view.viewmodel;

import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.category.CommonCategory;

import java.util.List;

/**
 * Created by Eduardo on 19/05/2016.
 */
public interface CategoryView extends ViewModel{

    void updateView(List<CommonCategory> categoryList);

}
