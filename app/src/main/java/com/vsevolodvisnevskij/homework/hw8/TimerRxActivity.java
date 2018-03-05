package com.vsevolodvisnevskij.homework.hw8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.vsevolodvisnevskij.homework.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class TimerRxActivity extends AppCompatActivity {
    private Disposable d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_rx);
        Observable<Long> myObservable = Observable.interval(500, TimeUnit.MILLISECONDS);
        TextView textView = findViewById(R.id.timer_textView);
        d = myObservable.filter(l -> l % 2 == 0).observeOn(AndroidSchedulers.mainThread()).subscribe(l -> textView.setText(String.valueOf(l)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        d.dispose();
    }
}
