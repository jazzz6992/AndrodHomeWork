package com.vsevolodvisnevskij.homework.hw9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;
import com.vsevolodvisnevskij.homework.databinding.ActivityProfileBinding;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ProfileActivity extends BaseMVVMActivity {


    @Override
    public int provideLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    public BaseViewModel provideViewModel(Bundle bundle) {
        return new UserViewModel();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
