package com.vsevolodvisnevskij.homework.screens.hw6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vsevolodvisnevskij.homework.base.BaseViewModel;
import com.vsevolodvisnevskij.homework.databinding.ActivityStockBinding;
import com.vsevolodvisnevskij.homework.databinding.ItemStockBinding;
import com.vsevolodvisnevskij.homework.screens.hw6.manager.Manager;
import com.vsevolodvisnevskij.homework.screens.hw6.model.entity.Stock;

import java.util.List;

/**
 * Created by vsevolodvisnevskij on 15.03.2018.
 */

public class RecyclerViewModel extends BaseViewModel {
    private static final String EXTRA_MANAGER = "com.vsevolodvisnevskij.homework.EXTRA_MANAGER";


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Manager manager;
    private LocalBroadcastManager broadcastManager;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            adapter.notifyDataSetChanged();
        }
    };
    ActivityStockBinding binding;

    private AppCompatActivity activity;
    private String search;

    public RecyclerViewModel(AppCompatActivity activity, ActivityStockBinding binding) {
        this.activity = activity;
        this.binding = binding;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
        manager.search(search);
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
        broadcastManager = LocalBroadcastManager.getInstance(activity);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Manager.ACTION_STOCKS_CHANGED);
        broadcastManager.registerReceiver(receiver, filter);
        manager = new Manager(broadcastManager);
        manager.getData(activity.getFilesDir().toString() + "/data.json");
        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new StockAdapter(manager.getStocksToDisplay());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        broadcastManager.unregisterReceiver(receiver);
    }

    class StockHolder extends RecyclerView.ViewHolder {
        ItemStockBinding binding;

        public StockHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            binding.setViewModel(new StockViewModel());
        }
    }

    class StockAdapter extends RecyclerView.Adapter<StockHolder> {
        private List<Stock> stocks;

        public StockAdapter(List<Stock> stocks) {
            this.stocks = stocks;
        }

        @Override
        public StockHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ItemStockBinding binding = ItemStockBinding.inflate(inflater, parent, false);
            return new StockHolder(binding.getRoot());
        }

        @Override
        public void onBindViewHolder(StockHolder holder, int position) {
            holder.binding.getViewModel().setStock(stocks.get(position));
        }

        @Override
        public int getItemCount() {
            if (stocks != null) {
                return stocks.size();
            } else {
                return 0;
            }
        }
    }
}