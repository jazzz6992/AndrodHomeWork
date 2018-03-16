package com.vsevolodvisnevskij.homework.hw7;

import android.content.Context;
import android.databinding.Bindable;
import android.support.v7.app.AppCompatActivity;

import com.vsevolodvisnevskij.homework.base.BaseViewModel;

import io.reactivex.disposables.Disposable;

/**
 * Created by vsevolodvisnevskij on 16.03.2018.
 */

public class ConsumerViewModel extends BaseViewModel {
    private Disposable disposable;
    private ObservableContract contract;
    private String text = "0";

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyChange();
    }

    public void setContract(ObservableContract contract) {
        this.contract = contract;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {
        disposable = contract.getObservable().map(String::valueOf).subscribe(this::setText);
    }

    @Override
    public void onPause() {
        disposable.dispose();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}
