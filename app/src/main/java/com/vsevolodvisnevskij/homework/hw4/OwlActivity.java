package com.vsevolodvisnevskij.homework.hw4;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.vsevolodvisnevskij.homework.R;

public class OwlActivity extends AppCompatActivity {

    AnimationDrawable owlAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owl);
        ImageView owlImageView = findViewById(R.id.owl_ImageView);
        owlImageView.setBackgroundResource(R.drawable.owl_animation_list);
        owlAnimation = (AnimationDrawable) owlImageView.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        owlAnimation.start();
    }
}
