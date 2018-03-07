package com.vsevolodvisnevskij.homework.hw3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.leakcanary.LeakCanary;
import com.vsevolodvisnevskij.homework.BuildConfig;
import com.vsevolodvisnevskij.homework.R;

public class RoundImageActivity extends AppCompatActivity {
    private static final String KEY_LOADED_LINK = "LOADED_LINK";
    private static final String KEY_LINK = "LINK";
    private ImageView imageView;
    private EditText linkEditText;
    private String imgLoaded = null;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_LOADED_LINK, imgLoaded);
        outState.putSerializable(KEY_LINK, linkEditText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(getApplication());
        setContentView(R.layout.activity_round_image);
        imageView = findViewById(R.id.imageView);
        linkEditText = findViewById(R.id.img_link_editText);
        Button getImgButton = findViewById(R.id.get_img_button);
        getImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImg(linkEditText.getText().toString());
                linkEditText.setText("");
            }
        });
        Button getSecretStringButton = findViewById(R.id.get_secret_string_button);
        getSecretStringButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RoundImageActivity.this, BuildConfig.API_ENDPOINT, Toast.LENGTH_LONG).show();
            }
        });
        if (savedInstanceState != null) {
            linkEditText.setText(savedInstanceState.getString(KEY_LINK));
            String link;
            if ((link = savedInstanceState.getString(KEY_LOADED_LINK)) != null) {
                getImg(link);
            }
        }
    }

    private void getImg(String link) {
        //как сделать, чтобы плейсхолдер не растягивался на всю ширину?? как сделать его тоже круглым???
        //почему при петеретягивании ползунка verticalBias картинка уходит в одну сторону, а placeholder в другую???
        RequestOptions requestOptions = new RequestOptions().circleCrop().placeholder(R.drawable.ic_access_time_black_24dp).error(R.drawable.err);
        Glide.with(getApplicationContext()).load(link).apply(requestOptions).into(imageView);
        imgLoaded = link;
    }
}
