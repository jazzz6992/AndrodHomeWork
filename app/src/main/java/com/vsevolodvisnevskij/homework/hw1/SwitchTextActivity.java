package com.vsevolodvisnevskij.homework.hw1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.leakcanary.LeakCanary;
import com.vsevolodvisnevskij.homework.R;

public class SwitchTextActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView firstTextView;
    private TextView secondTextView;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switchText();
        }
    };
    private static final String KEY_FIRST_TEXT = "FIRST_TEXT";
    private static final String KEY_SECOND_TEXT = "SECOND_TEXT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(getApplication());
        setContentView(R.layout.activity_switch_text);
        firstTextView = findViewById(R.id.first_textView);
        secondTextView = findViewById(R.id.second_textView);
        Button switchButton = findViewById(R.id.switch_button);
        firstTextView.setOnClickListener(this);
        secondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchText();
            }
        });
        switchButton.setOnClickListener(listener);
        if (savedInstanceState != null) {
            firstTextView.setText(savedInstanceState.getString(KEY_FIRST_TEXT));
            secondTextView.setText(savedInstanceState.getString(KEY_SECOND_TEXT));
        }
    }

    @Override
    public void onClick(View v) {
        switchText();
    }

    private void switchText() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            enableView(firstTextView, false);
            enableView(secondTextView, false);
            simpleSwitch();
            enableView(firstTextView, true);
            enableView(secondTextView, true);
        } else {
            simpleSwitch();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void enableView(final View view, boolean enable) {
        Animator animator;
        if (enable) {
            animator = ViewAnimationUtils.createCircularReveal(view, view.getWidth() / 2, view.getHeight() / 2, 0, view.getWidth());
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setVisibility(View.VISIBLE);
                }
            });
        } else {
            animator = ViewAnimationUtils.createCircularReveal(view, view.getWidth() / 2, view.getHeight() / 2, view.getWidth(), 0);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setVisibility(View.INVISIBLE);
                }
            });
        }
        animator.start();
    }

    private void simpleSwitch() {
        String textTmp = firstTextView.getText().toString();
        firstTextView.setText(secondTextView.getText());
        secondTextView.setText(textTmp);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_FIRST_TEXT, firstTextView.getText().toString());
        outState.putString(KEY_SECOND_TEXT, secondTextView.getText().toString());
    }
}
