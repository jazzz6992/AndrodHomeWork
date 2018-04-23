package com.vsevolodvisnevskij.homework.screens.hw4;

import android.os.Bundle;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;

public class AnimationActivity extends BaseMVVMActivity {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_animation;
    }

    @Override
    public AnimationViewModel provideViewModel(Bundle bundle) {
        return new AnimationViewModel(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setAnimation();
    }

    public void setAnimation() {

        overridePendingTransition(R.anim.animation_activity_in, R.anim.animation_activity_out);
    }
}
