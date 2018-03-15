package com.vsevolodvisnevskij.homework.hw4;


import android.content.Intent;

import com.vsevolodvisnevskij.homework.base.BaseViewModel;

/**
 * Created by vsevolodvisnevskij on 15.03.2018.
 */

public class AnimationViewModel extends BaseViewModel {
    AnimationActivity activity;

    public AnimationViewModel(AnimationActivity activity) {
        this.activity = activity;
    }


    public void startSimpleClock() {
        Intent intent = ClockActivity.newIntent(activity, ClockActivity.SIMPLE_CLOCK);
        activity.startActivity(intent);
        activity.setAnimation();
    }

    public void startOwl() {
        Intent intent = new Intent(activity, OwlActivity.class);
        activity.startActivity(intent);
        activity.setAnimation();
    }

    public void startOwlClock() {
        Intent intent = ClockActivity.newIntent(activity, ClockActivity.OWL_CLOCK);
        activity.startActivity(intent);
        activity.setAnimation();
    }


    @Override
    public void onStart() {

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
}
