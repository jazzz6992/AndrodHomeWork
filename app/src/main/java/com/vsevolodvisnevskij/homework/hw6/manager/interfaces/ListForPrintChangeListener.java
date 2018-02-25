package com.vsevolodvisnevskij.homework.hw6.manager.interfaces;

import com.vsevolodvisnevskij.homework.hw6.model.entity.Stock;

import java.util.List;

public interface ListForPrintChangeListener {
    void onListChanged(List<Stock> stocks);
}
