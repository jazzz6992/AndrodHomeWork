package com.vsevolodvisnevskij.homework.screens.hw6.manager.interfaces;

import com.vsevolodvisnevskij.homework.screens.hw6.model.entity.StockExchange;

public interface ParseCompleteListener {
    void onParseSuccess(StockExchange stockExchange);

    void onParseFailed(String message);
}
