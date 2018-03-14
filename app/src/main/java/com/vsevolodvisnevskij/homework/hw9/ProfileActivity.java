package com.vsevolodvisnevskij.homework.hw9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.databinding.ActivityProfileBinding;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ProfileActivity extends AppCompatActivity {
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        binding.setViewModel(new UserViewModel());
        Random random = new Random();
        boolean sex = random.nextBoolean();
        Observable<User> observable = Observable.just(new User(sex ? "http://pics.wikireality.ru/upload/1/1d/Mr.Freeman.jpg" : "http://makedo.ru/wp-content/uploads/2012/08/femen-pussy-riot_14.jpg", sex ? "Seva" : "Masha", 30, sex));
        disposable = observable.delay(2, TimeUnit.SECONDS).subscribe(user -> binding.getViewModel().setUser(user));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable.isDisposed()) {
            return;
        }
        disposable.dispose();
    }
}
