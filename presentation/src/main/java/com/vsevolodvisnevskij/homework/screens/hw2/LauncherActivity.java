package com.vsevolodvisnevskij.homework.screens.hw2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.databinding.ActivityLaunchBinding;
import com.vsevolodvisnevskij.homework.screens.hw1.SwitchTextActivity;
import com.vsevolodvisnevskij.homework.screens.hw3.RoundImageActivity;
import com.vsevolodvisnevskij.homework.screens.hw4.AnimationActivity;
import com.vsevolodvisnevskij.homework.screens.hw5.WiFiActivity;
import com.vsevolodvisnevskij.homework.screens.hw6.StockActivity;
import com.vsevolodvisnevskij.homework.screens.hw7.TryRxActivity;
import com.vsevolodvisnevskij.homework.screens.hw8.TimerRxActivity;
import com.vsevolodvisnevskij.homework.screens.hw9.ProfileActivity;

import java.util.ArrayList;
import java.util.List;

public class LauncherActivity extends BaseMVVMActivity<ActivityLaunchBinding, LauncherViewModel> implements View.OnClickListener {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_launch;
    }

    @Override
    public LauncherViewModel provideViewModel(Bundle bundle) {
        return new LauncherViewModel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Button> buttons = new ArrayList<>();
        buttons.add(binding.homework1Button);
        buttons.add(binding.homework2Button);
        buttons.add(binding.homework3Button);
        buttons.add(binding.homework4Button);
        buttons.add(binding.homework5Button);
        buttons.add(binding.homework6Button);
        buttons.add(binding.homework7Button);
        buttons.add(binding.homework8Button);
        buttons.add(binding.homework9Button);
        buttons.add(binding.homework10Button);
        buttons.add(binding.homework11Button);
        buttons.add(binding.homework12Button);
        buttons.add(binding.homework13Button);
        buttons.add(binding.homework14Button);
        buttons.add(binding.homework15Button);
        buttons.add(binding.homework16Button);
        buttons.add(binding.homework17Button);
        buttons.add(binding.homework18Button);

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
            case R.id.homework6_button:
                intent = new Intent(this, StockActivity.class);
                startActivity(intent);
                break;
            case R.id.homework7_button:
                intent = new Intent(this, TryRxActivity.class);
                startActivity(intent);
                break;
            case R.id.homework8_button:
                intent = new Intent(this, TimerRxActivity.class);
                startActivity(intent);
                break;
            case R.id.homework9_button:
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this, getResources().getString(R.string.patience_text), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
