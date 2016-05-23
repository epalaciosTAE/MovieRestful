package com.tae.movierestful.view.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by Eduardo on 18/05/2016.
 */
public interface FragmentFactory {

    Fragment newInstance(int position);
}
