package com.vsevolodvisnevskij.homework.screens.hw1;

import android.os.Bundle;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;
import com.vsevolodvisnevskij.homework.databinding.ActivitySwitchTextBinding;

public class SwitchTextActivity extends BaseMVVMActivity<ActivitySwitchTextBinding, SwitchViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_switch_text;
    }

    @Override
    public SwitchViewModel provideViewModel(Bundle bundle) {
        if (bundle != null) {
            return (SwitchViewModel) bundle.getSerializable(KEY_VIEW_MODEL);
        }
        return new SwitchViewModel();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_VIEW_MODEL, viewModel);
    }
}
