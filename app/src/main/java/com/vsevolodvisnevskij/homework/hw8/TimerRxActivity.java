package com.vsevolodvisnevskij.homework.hw8;

import android.os.Bundle;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;

import io.reactivex.disposables.Disposable;


public class TimerRxActivity extends BaseMVVMActivity {
    private Disposable d;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_timer_rx;
    }

    @Override
    public BaseViewModel provideViewModel(Bundle bundle) {
        return new TimerRxViewModel();
    }

}
