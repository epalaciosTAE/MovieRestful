package com.tae.movierestful.view.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by Eduardo on 22/05/2016.
 */
public class ImageViewDetail extends ImageView {


    public ImageViewDetail(Context context) {
        super(context);
        init();
    }

    private void init() {
        translateImageView();
    }

    private void translateImageView() {
        TranslateAnimation animation = new TranslateAnimation(0,0,400,0);
        animation.setDuration(1500);
        animation.setInterpolator(new LinearInterpolator());
        startAnimation(animation);
    }

    public ImageViewDetail(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageViewDetail(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
}
