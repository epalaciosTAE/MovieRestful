package com.tae.movierestful.di.component;

import com.tae.movierestful.data.api.service.category.CategoryServiceImpl;
import com.tae.movierestful.di.ActivityScope;
import com.tae.movierestful.di.module.CategoryModule;
import com.tae.movierestful.view.fragment.CategoryFragment;

import dagger.Component;

/**
 * Created by Eduardo on 18/05/2016.
 */
@ActivityScope
@Component(modules = CategoryModule.class, dependencies = ApplicationComponent.class)
public interface CategoryComponent {
    void inject(CategoryFragment fragment);
}
