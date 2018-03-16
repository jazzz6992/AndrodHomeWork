package com.vsevolodvisnevskij.homework.base;

import android.databinding.BaseObservable;

import java.io.Serializable;

/**
 * Created by vsevolodvisnevskij on 14.03.2018.
 */

public abstract class BaseViewModel extends BaseObservable implements Serializable {

    public abstract void onStart();

    public abstract void onStop();

    public abstract void onResume();

    public abstract void onPause();

    public abstract void onCreate();

    public abstract void onDestroy();


}
