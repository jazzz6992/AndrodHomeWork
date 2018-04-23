package com.vsevolodvisnevskij.homework.screens.hw6;

import android.os.Bundle;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;
import com.vsevolodvisnevskij.homework.databinding.ActivityStockBinding;

public class StockActivity extends BaseMVVMActivity<ActivityStockBinding, RecyclerViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_stock;
    }

    @Override
    public RecyclerViewModel provideViewModel(Bundle bundle) {
        return new RecyclerViewModel(this, (ActivityStockBinding) binding);
    }
}
