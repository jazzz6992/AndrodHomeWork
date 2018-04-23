package com.vsevolodvisnevskij.homework.screens.hw8;

import android.os.Bundle;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;
import com.vsevolodvisnevskij.homework.databinding.ActivityTimerRxBinding;


public class TimerRxActivity extends BaseMVVMActivity<ActivityTimerRxBinding, TimerRxViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_timer_rx;
    }

    @Override
    public TimerRxViewModel provideViewModel(Bundle bundle) {
        return new TimerRxViewModel();
    }

}
