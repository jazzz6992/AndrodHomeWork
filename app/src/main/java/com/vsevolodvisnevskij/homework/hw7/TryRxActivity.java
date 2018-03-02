package com.vsevolodvisnevskij.homework.hw7;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.vsevolodvisnevskij.homework.R;

import io.reactivex.subjects.PublishSubject;

public class TryRxActivity extends AppCompatActivity implements ObservableContract {
    private static final String KEY_COUNTER = "COUNTER";
    private PublishSubject<Integer> publishSubject;
    private Integer counter = 0;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_rx);
        View view = findViewById(R.id.clickable);
        view.setOnClickListener(v -> {
            counter++;
            publishSubject.onNext(counter);
        });
        publishSubject = PublishSubject.create();
        FragmentManager manager = getSupportFragmentManager();
        fragment = manager.findFragmentById(R.id.container);
        if (manager.findFragmentById(R.id.container) == null) {
            fragment = ConsumerFragment.getInstance();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.commit();
        }
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNTER);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, counter);
    }


    @Override
    public PublishSubject<Integer> getObservable() {
        return publishSubject;
    }
}
