package com.vsevolodvisnevskij.homework.hw5;

import android.os.Bundle;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;
import com.vsevolodvisnevskij.homework.databinding.ActivityWiFiBinding;

public class WiFiActivity extends BaseMVVMActivity {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_wi_fi;
    }

    @Override
    public BaseViewModel provideViewModel(Bundle bundle) {
        return new WiFiViewModel(this, (ActivityWiFiBinding) binding);
    }
}
