package com.vsevolodvisnevskij.homework.hw6.manager.search;

import com.vsevolodvisnevskij.homework.hw6.manager.interfaces.ListForPrintChangeListener;
import com.vsevolodvisnevskij.homework.hw6.model.Model;
import com.vsevolodvisnevskij.homework.hw6.model.entity.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher implements Runnable {

    private ListForPrintChangeListener listener;
    private Pattern pattern;
    private final Model model;

    public Searcher(ListForPrintChangeListener listener, String key, Model model) {
        this.listener = listener;
        //для поиска создается паттерн, содержащий ключ (не зависимо от регистра) с любым предшествующим и последующим кол-вом символов
        pattern = Pattern.compile("^.*" + key.toLowerCase() + ".*$");
        this.model = model;
    }

    @Override
    public void run() {
        /*
        в случае, если данные еще не готовы, ждет оповещения.
        затем ищет соответствующие ключу акции из списка для отображения, формирует из них новый
        список и оповещает слушателя по готовности
         */
        synchronized (model) {
            while (model.getStocksToDisplay() == null) {
                try {
                    model.wait();
                } catch (InterruptedException ignored) {
                }
            }
            List<Stock> stocks = model.getStockExchange().getStock();
            List<Stock> result = new ArrayList<>();
            Matcher matcher;
            for (Stock s :
                    stocks) {
                matcher = pattern.matcher(s.getName().toLowerCase());
                if (matcher.matches()) {
                    result.add(s);
                }
            }
            listener.onListChanged(result);
        }
    }
}

