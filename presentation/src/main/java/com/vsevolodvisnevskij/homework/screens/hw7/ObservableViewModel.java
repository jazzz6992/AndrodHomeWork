package com.vsevolodvisnevskij.homework.screens.hw7;

import com.vsevolodvisnevskij.homework.base.BaseViewModel;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by vsevolodvisnevskij on 16.03.2018.
 */

public class ObservableViewModel extends BaseViewModel implements ObservableContract {

    private PublishSubject<Integer> publishSubject;
    private Integer counter = 0;


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
        publishSubject = PublishSubject.create();
    }

    @Override
    public void onDestroy() {

    }

    public void sendNext() {
        counter++;
        publishSubject.onNext(counter);
    }

    @Override
    public PublishSubject<Integer> getObservable() {
        return publishSubject;
    }
}
