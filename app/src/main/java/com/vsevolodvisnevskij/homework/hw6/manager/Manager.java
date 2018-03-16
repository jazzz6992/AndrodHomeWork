package com.vsevolodvisnevskij.homework.hw6.manager;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.vsevolodvisnevskij.homework.hw6.StockActivity;
import com.vsevolodvisnevskij.homework.hw6.manager.download.Downloader;
import com.vsevolodvisnevskij.homework.hw6.manager.interfaces.DataChangedResultListener;
import com.vsevolodvisnevskij.homework.hw6.manager.interfaces.DownloadCompleteListener;
import com.vsevolodvisnevskij.homework.hw6.manager.interfaces.ListForPrintChangeListener;
import com.vsevolodvisnevskij.homework.hw6.manager.interfaces.ParseCompleteListener;
import com.vsevolodvisnevskij.homework.hw6.manager.parse.AbstractParser;
import com.vsevolodvisnevskij.homework.hw6.manager.parse.JsonParser;
import com.vsevolodvisnevskij.homework.hw6.manager.search.Searcher;
import com.vsevolodvisnevskij.homework.hw6.model.Model;
import com.vsevolodvisnevskij.homework.hw6.model.entity.Stock;
import com.vsevolodvisnevskij.homework.hw6.model.entity.StockExchange;

import java.io.File;
import java.io.Serializable;
import java.util.List;


public class Manager implements ListForPrintChangeListener, DataChangedResultListener, DownloadCompleteListener, ParseCompleteListener, Serializable {
    private static final String JSON_LINK = "http://kiparo.ru/t/stock.json";
    public static final String ACTION_STOCKS_CHANGED = "stock_changed";
    private final Model model;
    private final LocalBroadcastManager broadcastManager;
    public static final String LOG_TAG = "myLogs";


    public Manager(LocalBroadcastManager broadcastManager) {
        this.broadcastManager = broadcastManager;
        model = new Model(this);
    }

    public void getData(String fileName) {
        final Downloader downloader = new Downloader(JSON_LINK, fileName, this, model);
        Thread downloadThread = new Thread(downloader);
        downloadThread.start();
    }

    public void search(final String key) {
        if (key != null) {
            new Thread(new Searcher(this, key, model)).start();
        }
    }

    @Override
    public void onListChanged(List<Stock> stocks) {
        model.setStocksToDisplay(stocks);
    }


    @Override
    public void onDataChanged() {
        sendLocalBroadcast();
    }

    @Override
    public void onDownloadSuccess(File file) {
        model.setFile(file);
        final AbstractParser parser = new JsonParser(model, this);
        parser.run();
    }

    @Override
    public void onDownloadFailed(String message) {
        Log.d(LOG_TAG, "download Failed");
    }

    @Override
    public void onParseSuccess(StockExchange stockExchange) {
        model.setStockExchange(stockExchange);
        sendLocalBroadcast();
    }

    @Override
    public void onParseFailed(String message) {
        Log.d(LOG_TAG, "parse Failed");
    }

    public List<Stock> getStocksToDisplay() {
        return model.getStocksToDisplay();
    }

    private void sendLocalBroadcast() {
        Intent intent = new Intent(ACTION_STOCKS_CHANGED);
        broadcastManager.sendBroadcast(intent);
    }
}
