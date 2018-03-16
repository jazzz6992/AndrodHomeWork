package com.vsevolodvisnevskij.homework.screens.hw4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;
import com.vsevolodvisnevskij.homework.databinding.ActivityClockBinding;

public class ClockActivity extends BaseMVVMActivity {
    private static final String EXTRA_CLOCK_TYPE = "CLOCK_TYPE";
    public static final int SIMPLE_CLOCK = 0;
    public static final int OWL_CLOCK = 1;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_clock;
    }

    @Override
    public BaseViewModel provideViewModel(Bundle bundle) {
        int type = getIntent().getIntExtra(EXTRA_CLOCK_TYPE, -1);
        return new ClockViewModel(type, this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ActivityClockBinding) binding).getViewModel().setContainer(binding.getRoot().findViewById(R.id.clock_container));
    }


    public static Intent newIntent(Context context, int type) {
        Intent intent = new Intent(context, ClockActivity.class);
        intent.putExtra(EXTRA_CLOCK_TYPE, type);
        return intent;
    }
}
