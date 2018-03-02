package com.vsevolodvisnevskij.homework.hw6.manager.parse;

import com.vsevolodvisnevskij.homework.hw6.manager.interfaces.ParseCompleteListener;
import com.vsevolodvisnevskij.homework.hw6.model.Model;

import java.io.File;

public abstract class AbstractParser implements Runnable {
    /*
    в соответствии с полиморфизмом все данные и методы парсера определены в
    абстрактном классе. сам метод parse реализован в конкретных парсерах
     */
    private final Model model;
    private ParseCompleteListener listener;

    AbstractParser(Model model, ParseCompleteListener listener) {
        this.model = model;
        this.listener = listener;
    }

    abstract void parse(File source);

    @Override
    public void run() {
        synchronized (model) {
            parse(model.getFile());
        }
    }

    public ParseCompleteListener getListener() {
        return listener;
    }
}
