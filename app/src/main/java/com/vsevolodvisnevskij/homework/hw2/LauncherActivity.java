package com.vsevolodvisnevskij.homework.hw2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.leakcanary.LeakCanary;
import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.hw5.WiFiActivity;
import com.vsevolodvisnevskij.homework.hw1.SwitchTextActivity;
import com.vsevolodvisnevskij.homework.hw3.RoundImageActivity;
import com.vsevolodvisnevskij.homework.hw4.AnimationActivity;

import java.util.ArrayList;
import java.util.List;

public class LauncherActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(getApplication());
        setContentView(R.layout.activity_launcher);
        List<Button> buttons = new ArrayList<>();
        buttons.add((Button) findViewById(R.id.homework1_button));
        buttons.add((Button) findViewById(R.id.homework2_button));
        buttons.add((Button) findViewById(R.id.homework3_button));
        buttons.add((Button) findViewById(R.id.homework4_button));
        buttons.add((Button) findViewById(R.id.homework5_button));
        buttons.add((Button) findViewById(R.id.homework6_button));
        buttons.add((Button) findViewById(R.id.homework7_button));
        buttons.add((Button) findViewById(R.id.homework8_button));
        buttons.add((Button) findViewById(R.id.homework9_button));
        buttons.add((Button) findViewById(R.id.homework10_button));
        buttons.add((Button) findViewById(R.id.homework11_button));
        buttons.add((Button) findViewById(R.id.homework12_button));
        buttons.add((Button) findViewById(R.id.homework13_button));
        buttons.add((Button) findViewById(R.id.homework14_button));
        buttons.add((Button) findViewById(R.id.homework15_button));
        buttons.add((Button) findViewById(R.id.homework16_button));
        buttons.add((Button) findViewById(R.id.homework17_button));
        buttons.add((Button) findViewById(R.id.homework18_button));
        for (Button b : buttons) {
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.homework1_button:
                intent = new Intent(this, SwitchTextActivity.class);
                startActivity(intent);
                break;
            case R.id.homework2_button:
                intent = new Intent(this, FlagsActivity.class);
                startActivity(intent);
                break;
            case R.id.homework3_button:
                intent = new Intent(this, RoundImageActivity.class);
                startActivity(intent);
                break;
            case R.id.homework4_button:
                intent = new Intent(this, AnimationActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animation_activity_in, R.anim.animation_activity_out);
                break;
            case R.id.homework5_button:
                intent = new Intent(this, WiFiActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this, getResources().getString(R.string.patience_text), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
