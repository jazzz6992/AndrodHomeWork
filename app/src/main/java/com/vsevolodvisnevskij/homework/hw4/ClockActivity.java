package com.vsevolodvisnevskij.homework.hw4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.vsevolodvisnevskij.homework.R;

public class ClockActivity extends AppCompatActivity {
    private static final String EXTRA_CLOCK_TYPE = "CLOCK_TYPE";
    public static final int SIMPLE_CLOCK = 0;
    public static final int OWL_CLOCK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        FrameLayout layout = findViewById(R.id.clock_container);
        int type = getIntent().getIntExtra(EXTRA_CLOCK_TYPE, -1);
        switch (type) {
            case SIMPLE_CLOCK:
                layout.addView(new ClockView(getApplicationContext()));
                break;
            case OWL_CLOCK:
                layout.addView(new OwlClockView(getApplicationContext()));
                break;
        }
    }


    public static Intent newIntent(Context context, int type) {
        Intent intent = new Intent(context, ClockActivity.class);
        intent.putExtra(EXTRA_CLOCK_TYPE, type);
        return intent;
    }
}
