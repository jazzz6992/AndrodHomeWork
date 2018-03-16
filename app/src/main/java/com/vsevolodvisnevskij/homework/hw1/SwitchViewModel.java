package com.vsevolodvisnevskij.homework.hw1;

import android.databinding.Bindable;
import android.view.View;

import com.vsevolodvisnevskij.homework.base.BaseViewModel;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by vsevolodvisnevskij on 14.03.2018.
 */

public class SwitchViewModel extends BaseViewModel {
    private TextFields textFields;
    private boolean isSwitched = false;
    private Disposable disposable;

    public void setTextFields(TextFields textFields) {
        this.textFields = textFields;
        notifyChange();
    }

    @Bindable
    public String getFirstText() {
        if (textFields != null) {
            return !isSwitched ? textFields.getFirstText() : textFields.getSecondText();
        }
        return null;
    }

    @Bindable
    public String getSecondText() {
        if (textFields != null) {
            return !isSwitched ? textFields.getSecondText() : textFields.getFirstText();
        }
        return null;
    }

    public void changeText(View v) {
        isSwitched = !isSwitched;
        notifyChange();
    }


    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onResume() {
        disposable = Observable.just(new TextFields("Кручу-верчу", "Запутать хочу")).subscribe(this::setTextFields);
    }

    @Override
    public void onPause() {
        disposable.dispose();
    }
}
