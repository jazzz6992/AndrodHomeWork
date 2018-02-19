package com.vsevolodvisnevskij.homework.hw4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.vsevolodvisnevskij.homework.R;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        Button clockButton = findViewById(R.id.show_clock_button);
        clockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ClockActivity.newIntent(getApplicationContext(), ClockActivity.SIMPLE_CLOCK);
                startActivity(intent);
                setAnimation();
            }
        });

        Button owlButton = findViewById(R.id.show_owl_button);
        owlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OwlActivity.class);
                startActivity(intent);
                setAnimation();
            }
        });
        Button owlClockButton = findViewById(R.id.show_owl_clock_button);
        owlClockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ClockActivity.newIntent(getApplicationContext(), ClockActivity.OWL_CLOCK);
                startActivity(intent);
                setAnimation();
            }
        });
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
