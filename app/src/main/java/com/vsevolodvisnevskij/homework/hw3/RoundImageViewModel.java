package com.vsevolodvisnevskij.homework.hw3;

import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.vsevolodvisnevskij.homework.BuildConfig;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;

/**
 * Created by vsevolodvisnevskij on 14.03.2018.
 */

public class RoundImageViewModel extends BaseViewModel {
    private String text;
    private String loadedLink;
    private String secretText;

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Bindable
    public String getLoadedLink() {
        return loadedLink;
    }

    public void setLoadedLink(String loadedLink) {
        this.loadedLink = loadedLink;
    }

    @Bindable
    public String getSecretText() {
        return secretText;
    }

    public void setSecretText(String secretText) {
        this.secretText = secretText;
    }

    public void loadImg() {
        loadedLink = text;
        notifyPropertyChanged(BR.loadedLink);
    }

    public void showSecretString() {
        setSecretText(BuildConfig.API_ENDPOINT);
        notifyPropertyChanged(BR.secretText);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}
