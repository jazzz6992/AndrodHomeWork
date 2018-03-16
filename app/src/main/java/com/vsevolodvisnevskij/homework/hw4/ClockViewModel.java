package com.vsevolodvisnevskij.homework.hw4;

import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.vsevolodvisnevskij.homework.base.BaseViewModel;

/**
 * Created by vsevolodvisnevskij on 15.03.2018.
 */

public class ClockViewModel extends BaseViewModel {
    private AppCompatActivity activity;
    private FrameLayout container;
    private int viewType;

    public ClockViewModel(int viewType, AppCompatActivity appCompatActivity) {
        activity = appCompatActivity;
        this.viewType = viewType;
    }

    public void setContainer(FrameLayout container) {
        this.container = container;
    }

    @Override
    public void onStart() {
        switch (viewType) {
            case ClockActivity.SIMPLE_CLOCK:
                container.addView(new ClockView(activity));
                break;
            case ClockActivity.OWL_CLOCK:
                container.addView(new OwlClockView(activity));
                break;
        }
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}
