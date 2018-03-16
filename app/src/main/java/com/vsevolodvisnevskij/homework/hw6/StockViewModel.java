package com.vsevolodvisnevskij.homework.hw6;

import android.databinding.Bindable;

import com.vsevolodvisnevskij.homework.base.BaseViewModel;
import com.vsevolodvisnevskij.homework.hw6.model.entity.Stock;

/**
 * Created by vsevolodvisnevskij on 15.03.2018.
 */

public class StockViewModel extends BaseViewModel {
    private Stock stock;

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
        notifyChange();
    }

    @Bindable
    public String getStockId() {
        if (stock != null) {
            return String.valueOf(stock.getId());
        }
        return null;
    }

    @Bindable
    public String getStockName() {
        if (stock != null) {
            return stock.getName();
        }
        return null;
    }

    @Bindable
    public String getStockBid() {
        if (stock != null) {
            return String.valueOf(stock.getBid());
        }
        return null;
    }

    @Bindable
    public String getStockMinPrice() {
        if (stock != null) {
            return String.valueOf(stock.getMinPrice());
        }
        return null;
    }

    @Bindable
    public String getStockMaxPrice() {
        if (stock != null) {
            return String.valueOf(stock.getMaxPrice());
        }
        return null;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}
