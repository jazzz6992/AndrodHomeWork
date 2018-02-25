package com.vsevolodvisnevskij.homework.hw6.manager.interfaces;

import com.vsevolodvisnevskij.homework.hw6.model.entity.StockExchange;

public interface ParseCompleteListener {
    void onParseSuccess(StockExchange stockExchange);

    void onParseFailed(String message);
}
