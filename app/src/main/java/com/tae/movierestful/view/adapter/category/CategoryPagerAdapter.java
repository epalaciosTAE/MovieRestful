package com.tae.movierestful.view.adapter.category;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tae.movierestful.view.MovieApp;
import com.tae.movierestful.view.fragment.FragmentFactory;

import javax.inject.Inject;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class CategoryPagerAdapter extends FragmentStatePagerAdapter {

    private static final int TOTAL_FRAGMENTS = 3;

    @Inject
    FragmentFactory fragmentFactory;

    public CategoryPagerAdapter(FragmentManager fm) {
        super(fm);
        resolveDependencies();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentFactory.newInstance(position);
    }

    @Override
    public int getCount() {
        return TOTAL_FRAGMENTS;
    }

    private void resolveDependencies() {
        MovieApp.getInstance().getApplicationComponent().inject(this);
    }

}
