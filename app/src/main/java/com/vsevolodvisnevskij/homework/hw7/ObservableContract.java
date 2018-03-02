package com.vsevolodvisnevskij.homework.hw7;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by vsevolodvisnevskij on 02.03.2018.
 */

interface ObservableContract {
    PublishSubject<Integer> getObservable();
}
