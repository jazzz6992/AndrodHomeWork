package com.vsevolodvisnevskij.homework.screens.hw3;

import android.os.Bundle;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;

public class RoundImageActivity extends BaseMVVMActivity {

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_VIEW_MODEL, viewModel);
    }

    @Override
    public int provideLayoutId() {
        return R.layout.activity_round_image;
    }

    @Override
    public RoundImageViewModel provideViewModel(Bundle bundle) {
        if (bundle != null) {
            return (RoundImageViewModel) bundle.getSerializable(KEY_VIEW_MODEL);
        }
        return new RoundImageViewModel();
    }
}