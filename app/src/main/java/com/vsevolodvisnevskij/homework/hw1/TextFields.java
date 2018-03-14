package com.vsevolodvisnevskij.homework.hw1;

/**
 * Created by vsevolodvisnevskij on 14.03.2018.
 */

public class TextFields {
    private String firstText;
    private String secondText;

    public TextFields(String firstText, String secondText) {
        this.firstText = firstText;
        this.secondText = secondText;
    }

    public String getFirstText() {
        return firstText;
    }

    public String getSecondText() {
        return secondText;
    }

    public void setFirstText(String firstText) {
        this.firstText = firstText;
    }

    public void setSecondText(String secondText) {
        this.secondText = secondText;
    }
}
