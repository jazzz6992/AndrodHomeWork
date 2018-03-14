package com.vsevolodvisnevskij.homework.hw1;

import android.os.Bundle;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;

public class SwitchTextActivity extends BaseMVVMActivity {

    private static final String KEY_VIEW_MODEL = "view_model";

    @Override
    public int provideLayoutId() {
        return R.layout.activity_switch_text;
    }

    @Override
    public BaseViewModel provideViewModel(Bundle bundle) {
        if (bundle != null) {
            return (BaseViewModel) bundle.getSerializable(KEY_VIEW_MODEL);
        }
        return new SwitchViewModel();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_VIEW_MODEL, viewModel);
    }
}
