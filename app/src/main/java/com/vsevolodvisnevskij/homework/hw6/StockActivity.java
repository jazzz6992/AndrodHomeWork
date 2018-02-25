package com.vsevolodvisnevskij.homework.hw6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.hw6.manager.Manager;
import com.vsevolodvisnevskij.homework.hw6.model.entity.Stock;

import java.util.List;

public class StockActivity extends AppCompatActivity {
    private static final String EXTRA_MANAGER = "com.vsevolodvisnevskij.homework.EXTRA_MANAGER";
    public static String ACTION_STOCKS_CHANGED = "com.vsevolodvisnevskij.homework.ACTION_STOCKS_CHANGED";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private EditText searchEditText;
    private Manager manager;
    private LocalBroadcastManager broadcastManager;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        broadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_STOCKS_CHANGED);
        broadcastManager.registerReceiver(receiver, filter);
        if (savedInstanceState != null) {
            manager = (Manager) savedInstanceState.getSerializable(EXTRA_MANAGER);
        } else {
            manager = new Manager(broadcastManager);
        }
        manager.getData(getFilesDir().toString() + "/data.json");
        searchEditText = findViewById(R.id.search_editText);
        searchEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                manager.search(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StockAdapter(manager.getStocksToDisplay());
        recyclerView.setAdapter(adapter);

    }

    class StockHolder extends RecyclerView.ViewHolder {
        private TextView idTextView;
        private TextView nameTextView;
        private TextView bidTextView;
        private TextView minPriceTextView;
        private TextView maxPriceTextView;

        public StockHolder(View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.stock_id);
            nameTextView = itemView.findViewById(R.id.stock_name);
            bidTextView = itemView.findViewById(R.id.stock_bid);
            minPriceTextView = itemView.findViewById(R.id.stock_min_price);
            maxPriceTextView = itemView.findViewById(R.id.stock_max_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), nameTextView.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }

        public void bind(Stock stock) {
            idTextView.setText(String.format(getString(R.string.stock_id), stock.getId()));
            nameTextView.setText(String.format(getString(R.string.stock_name), stock.getName()));
            bidTextView.setText(String.format(getString(R.string.stock_bid), stock.getBid()));
            minPriceTextView.setText(String.format(getString(R.string.stock_min_price), stock.getMinPrice()));
            maxPriceTextView.setText(String.format(getString(R.string.stock_max_price), stock.getMaxPrice()));
        }
    }

    class StockAdapter extends RecyclerView.Adapter<StockHolder> {
        private List<Stock> stocks;

        public StockAdapter(List<Stock> stocks) {
            this.stocks = stocks;
        }

        @Override
        public StockHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(StockActivity.this).inflate(R.layout.item_stock, parent, false);
            return new StockHolder(v);
        }

        @Override
        public void onBindViewHolder(StockHolder holder, int position) {
            holder.bind(stocks.get(position));
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EXTRA_MANAGER, manager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        broadcastManager.unregisterReceiver(receiver);
    }
}
