package com.tae.movierestful.view.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tae.movierestful.R;
import com.tae.movierestful.data.local.constants.LocalConstans;
import com.tae.movierestful.utils.TitleFactory;
import com.tae.movierestful.view.MovieApp;
import com.tae.movierestful.view.adapter.category.CategoryPagerAdapter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, ScreenLauncher {

    @Bind(R.id.categoryPager)
    ViewPager viewPager;
    @Bind(R.id.tvCategory)
    TextView categoryTextView;

    @Inject
    TitleFactory titleFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        resolveDependencies();
        initViewPager();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        categoryTextView.setText(titleFactory.getTitle(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void launchDetailScreen(long id, String type) {
        ActivityOptionsCompat transition = getTransition();

        startActivity(
                new Intent(this, DetailActivity.class)
                        .putExtra(LocalConstans.EXTRA_ID, id)
                        .putExtra(LocalConstans.EXTRA_TYPE, type),
                transition.toBundle());
    }
    @TargetApi(21)
    @NonNull
    private ActivityOptionsCompat getTransition() {
        ImageView imageView = (ImageView) findViewById(R.id.imageDetail);

        return ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                new Pair<View, String>(imageView,
                        getString(R.string.imageTransition)));
    }

    private void initViewPager() {
        viewPager.setAdapter(new CategoryPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(this);
    }

    private void resolveDependencies() {
        MovieApp.getInstance().getApplicationComponent().inject(this);
    }
}
