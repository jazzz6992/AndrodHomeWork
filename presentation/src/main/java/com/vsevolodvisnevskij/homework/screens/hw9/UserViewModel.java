package com.vsevolodvisnevskij.homework.screens.hw9;

import android.databinding.Bindable;

import com.vsevolodvisnevskij.homework.base.BaseViewModel;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by vsevolodvisnevskij on 07.03.2018.
 */

public class UserViewModel extends BaseViewModel {
    private User user;
    private boolean loaded = false;
    private Disposable disposable;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        loaded = true;
        notifyChange();
    }

    @Bindable
    public String getUserName() {
        if (user != null) {
            return user.getName();
        }
        return null;
    }

    @Bindable
    public String getUserAge() {
        if (user != null) {
            return String.valueOf(user.getAge());
        }
        return null;
    }

    @Bindable
    public Boolean getUserGender() {
        if (user != null) {
            return user.isGender();
        }
        return null;
    }

    @Bindable
    public String getUserImgUrl() {
        if (user != null) {
            return user.getImgUrl();
        }
        return null;
    }

    @Bindable
    public boolean isLoaded() {
        return loaded;
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
        Random random = new Random();
        boolean sex = random.nextBoolean();
        Observable<User> observable = Observable.just(new User(sex ? "http://pics.wikireality.ru/upload/1/1d/Mr.Freeman.jpg" : "http://makedo.ru/wp-content/uploads/2012/08/femen-pussy-riot_14.jpg", sex ? "Seva" : "Masha", 30, sex));
        disposable = observable.delay(2, TimeUnit.SECONDS).subscribe(this::setUser);
    }

    @Override
    public void onDestroy() {
        if (disposable.isDisposed()) {
            return;
        }
        disposable.dispose();
    }
}
