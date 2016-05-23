package com.tae.movierestful.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.tae.movierestful.data.local.category.CategoryType;

import javax.inject.Inject;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class FragmentFactoryImpl implements FragmentFactory {

    @Inject
    public FragmentFactoryImpl() {
    }

    public Fragment newInstance(int position) {
        String type = CategoryType.getType(position);
        Bundle bundle = getBundle(type);
        return getFragment(bundle);
    }

    @NonNull
    private Fragment getFragment(Bundle bundle) {
        Fragment fragment = new CategoryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @NonNull
    private Bundle getBundle(String type) {
        Bundle bundle = new Bundle();
        bundle.putString(CategoryType.TYPE, type);
        return bundle;
    }

}
