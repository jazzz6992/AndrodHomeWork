package com.vsevolodvisnevskij.homework.screens.hw6.manager.interfaces;

import com.vsevolodvisnevskij.homework.screens.hw6.model.entity.Stock;

import java.util.List;

public interface ListForPrintChangeListener {
    void onListChanged(List<Stock> stocks);
}
