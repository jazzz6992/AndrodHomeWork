package com.vsevolodvisnevskij.homework.screens.hw2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableRow;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMActivity;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;
import com.vsevolodvisnevskij.homework.databinding.ActivityFlagsBinding;


public class FlagsActivity extends BaseMVVMActivity {
    private LinearLayout.LayoutParams params;


    @Override
    public int provideLayoutId() {
        return R.layout.activity_flags;
    }

    @Override
    public BaseViewModel provideViewModel(Bundle bundle) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        //получаем коофициент плотности пикселей для последующего получения правильного отступа в физических пикселях
        float density = displaymetrics.density;
        //отступ в физических пикселях будет варьироваться в зависимости от индекса плотности пикселей
        int margin = (int) (density * 10 + 0.5f);
        int flagWidth;
        int flagHeight;
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            flagWidth = displaymetrics.widthPixels / 4 * 3;
            flagHeight = flagWidth / 4 * 3;
            params = new LinearLayout.LayoutParams(flagWidth, flagHeight);
        } else {
            flagWidth = displaymetrics.widthPixels / 5 * 2;
            flagHeight = flagWidth / 4 * 3;
            params = new TableRow.LayoutParams(flagWidth, flagHeight);
        }
        params.setMargins(margin, margin, margin, margin);
        ActivityFlagsBinding activityFlagsBinding = (ActivityFlagsBinding) binding;
        setFlagLayoutParams(activityFlagsBinding.austriaFlag);
        setFlagLayoutParams(activityFlagsBinding.polandFlag);
        setFlagLayoutParams(activityFlagsBinding.italyFlag);
        setFlagLayoutParams(activityFlagsBinding.columbiaFlag);
        setFlagLayoutParams(activityFlagsBinding.madagascarFlag);
        setFlagLayoutParams(activityFlagsBinding.taiFlag);
        setFlagLayoutParams(activityFlagsBinding.denmarkFlag);
    }

    private void setFlagLayoutParams(View view) {
        view.setLayoutParams(params);
    }
}