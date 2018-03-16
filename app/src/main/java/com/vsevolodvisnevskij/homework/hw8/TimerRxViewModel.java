package com.vsevolodvisnevskij.homework.hw8;

import android.databinding.Bindable;

import com.vsevolodvisnevskij.homework.base.BaseViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by vsevolodvisnevskij on 16.03.2018.
 */

public class TimerRxViewModel extends BaseViewModel {
    private Disposable d;
    private String timer;

    @Bindable
    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
        notifyChange();
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
        Observable<Long> myObservable = Observable.interval(500, TimeUnit.MILLISECONDS);
        d = myObservable.filter(l -> l % 2 == 0).observeOn(AndroidSchedulers.mainThread()).subscribe(l -> setTimer(String.valueOf(l)));
    }

    @Override
    public void onDestroy() {
        d.dispose();
    }
}
