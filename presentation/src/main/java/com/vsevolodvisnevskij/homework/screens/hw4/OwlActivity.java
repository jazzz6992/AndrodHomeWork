package com.vsevolodvisnevskij.homework.screens.hw4;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;

public class OwlActivity extends BaseMVVMActivity {

    AnimationDrawable owlAnimation;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_owl;
    }

    @Override
    public BaseViewModel provideViewModel(Bundle bundle) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView owlImageView = binding.getRoot().findViewById(R.id.owl_ImageView);
        owlImageView.setBackgroundResource(R.drawable.owl_animation_list);
        owlAnimation = (AnimationDrawable) owlImageView.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        owlAnimation.start();
    }
}
