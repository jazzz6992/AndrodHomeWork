package com.vsevolodvisnevskij.homework.hw4;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.vsevolodvisnevskij.homework.R;

/**
 * Created by vsevolodvisnevskij on 19.02.2018.
 */

public class OwlClockView extends FrameLayout {
    LayoutParams params;
    ClockView clockView;
    ImageView imageView;
    AnimationDrawable owlAnimation;

    public OwlClockView(@NonNull Context context) {
        super(context);
        init();
    }

    public OwlClockView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OwlClockView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public OwlClockView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        clockView = new ClockView(getContext());
        imageView = new ImageView(getContext());
        imageView.setBackgroundResource(R.drawable.owl_animation_list);
        owlAnimation = (AnimationDrawable) imageView.getBackground();
        addView(clockView);
        addView(imageView);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int owlHeight = h > w ? h / 15 : w / 15;
        int owlWidth = (int) (owlHeight * 0.75);
        params = new LayoutParams(owlWidth, owlHeight, Gravity.CENTER);
        imageView.setLayoutParams(params);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        owlAnimation.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        owlAnimation.stop();
    }
}
