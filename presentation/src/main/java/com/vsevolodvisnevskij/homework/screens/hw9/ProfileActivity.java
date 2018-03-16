package com.vsevolodvisnevskij.homework.screens.hw9;

import android.os.Bundle;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;

public class ProfileActivity extends BaseMVVMActivity {


    @Override
    public int provideLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    public BaseViewModel provideViewModel(Bundle bundle) {
        if (bundle != null) {
            return (UserViewModel) bundle.getSerializable(KEY_VIEW_MODEL);
        }
        return new UserViewModel();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_VIEW_MODEL, viewModel);
    }
}
