package com.vsevolodvisnevskij.homework.base;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.vsevolodvisnevskij.homework.hw9.CircleTransformation;

/**
 * Created by vsevolodvisnevskij on 14.03.2018.
 */

public class BindingAdapters {
    @BindingAdapter({"android:src", "android:error", "android:placeholder"})
    public static void loadImage(ImageView view, String url, Drawable err, Drawable placeholder) {
        Picasso.with(view.getContext()).load(url).placeholder(placeholder).error(err).transform(new CircleTransformation()).into(view);
    }
}
