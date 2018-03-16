package com.vsevolodvisnevskij.homework.hw7;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;

import io.reactivex.subjects.PublishSubject;

public class TryRxActivity extends BaseMVVMActivity implements ObservableContract {
    private Fragment fragment;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_try_rx;
    }

    @Override
    public BaseViewModel provideViewModel(Bundle bundle) {
        if (bundle != null) {
            return (ObservableViewModel) bundle.getSerializable(KEY_VIEW_MODEL);
        }
        return new ObservableViewModel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getSupportFragmentManager();
        fragment = manager.findFragmentById(R.id.container);
        if (manager.findFragmentById(R.id.container) == null) {
            fragment = ConsumerFragment.getInstance();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_VIEW_MODEL, viewModel);
    }

    @Override
    public PublishSubject<Integer> getObservable() {
        return ((ObservableContract) viewModel).getObservable();
    }
}
