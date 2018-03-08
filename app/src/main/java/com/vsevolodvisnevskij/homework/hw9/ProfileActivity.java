package com.vsevolodvisnevskij.homework.hw9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.databinding.ActivityProfileBinding;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ProfileActivity extends AppCompatActivity {
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        binding.setUserVM(new UserViewModel());
        Observable<User> observable = Observable.just(new User("http://pics.wikireality.ru/upload/1/1d/Mr.Freeman.jpg", "Seva", 30, true));
        disposable = observable.delay(2, TimeUnit.SECONDS).subscribe(user -> binding.getUserVM().setUser(user));
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
