package com.vsevolodvisnevskij.homework.screens.hw6.manager.parse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vsevolodvisnevskij.homework.screens.hw6.manager.interfaces.ParseCompleteListener;
import com.vsevolodvisnevskij.homework.screens.hw6.model.Model;
import com.vsevolodvisnevskij.domain.entity.StockExchange;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

public class JsonParser extends AbstractParser {

    public JsonParser(Model model, ParseCompleteListener listener) {
        super(model, listener);
    }

    //парсит данные из файла и оповещает слушателя о результате
    @Override
    public void parse(File source) {
        StockExchange stockExchange;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateGsonConverter());
        Gson gson = builder.create();
        try {
            FileReader reader = new FileReader(source);
            stockExchange = gson.fromJson(reader, StockExchange.class);
            getListener().onParseSuccess(stockExchange);
        } catch (FileNotFoundException e) {
            getListener().onParseFailed(e.getMessage());
        }
    }
}
