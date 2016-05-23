package com.tae.movierestful.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tae.movierestful.R;
import com.tae.movierestful.data.api.service.ErrorResponse;
import com.tae.movierestful.data.local.category.CategoryType;
import com.tae.movierestful.data.local.category.CommonCategory;
import com.tae.movierestful.di.component.DaggerCategoryComponent;
import com.tae.movierestful.di.module.CategoryModule;
import com.tae.movierestful.presenter.CategoryPresenter;
import com.tae.movierestful.view.adapter.category.CategoryAdapter;
import com.tae.movierestful.view.viewmodel.CategoryView;
import com.tae.movierestful.view.MovieApp;
import com.tae.movierestful.view.activity.ScreenLauncher;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class CategoryFragment extends Fragment implements CategoryView {

    @Bind(R.id.categoryList)
    RecyclerView recyclerView;

    @Inject
    CategoryPresenter presenter;
    @Inject
    CategoryAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resolveDependencies();
        String categoryType = getArguments().getString(CategoryType.TYPE);
        presenter.requestCategory(categoryType);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_fragment, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void updateView(List<CommonCategory> categoryList) {
        adapter.updateItems(categoryList);
    }

    @Override
    public void updateViewOnError(ErrorResponse error) {
        Toast.makeText(getActivity(), "Error: " + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void resolveDependencies() {
        DaggerCategoryComponent.builder()
                .applicationComponent(MovieApp.getInstance().getApplicationComponent())
                .categoryModule(new CategoryModule(this, (ScreenLauncher) getActivity()))
                .build()
                .inject(this);
    }
}
