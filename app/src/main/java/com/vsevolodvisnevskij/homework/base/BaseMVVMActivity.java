package com.vsevolodvisnevskij.homework.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vsevolodvisnevskij.homework.BR;


public abstract class BaseMVVMActivity<Binding extends ViewDataBinding, ViewModel extends BaseViewModel> extends AppCompatActivity {
    protected Binding binding;
    protected ViewModel viewModel;

    public abstract int provideLayoutId();

    public abstract ViewModel provideViewModel(Bundle bundle);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, provideLayoutId());
        viewModel = provideViewModel(savedInstanceState);
        binding.setVariable(BR.viewModel, viewModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (viewModel != null) {
            viewModel.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (viewModel != null) {
            viewModel.onPause();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (viewModel != null) {
            viewModel.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (viewModel != null) {
            viewModel.onStop();
        }
    }
}
