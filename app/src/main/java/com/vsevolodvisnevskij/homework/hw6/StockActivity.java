package com.vsevolodvisnevskij.homework.hw6;

import android.os.Bundle;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;
import com.vsevolodvisnevskij.homework.databinding.ActivityStockBinding;

public class StockActivity extends BaseMVVMActivity {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_stock;
    }

    @Override
    public BaseViewModel provideViewModel(Bundle bundle) {
        return new RecyclerViewModel(this, (ActivityStockBinding) binding);
    }
}
