package com.vsevolodvisnevskij.homework.hw2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableRow;

import com.vsevolodvisnevskij.homework.R;

public class FlagsActivity extends AppCompatActivity {
    LinearLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);
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
        setFlagLayoutParams(R.id.austria_flag);
        setFlagLayoutParams(R.id.poland_flag);
        setFlagLayoutParams(R.id.italy_flag);
        setFlagLayoutParams(R.id.columbia_flag);
        setFlagLayoutParams(R.id.madagascar_flag);
        setFlagLayoutParams(R.id.tai_flag);
        setFlagLayoutParams(R.id.denmark_flag);
    }

    private void setFlagLayoutParams(int id) {
        View view = findViewById(id);
        view.setLayoutParams(params);
    }
}
