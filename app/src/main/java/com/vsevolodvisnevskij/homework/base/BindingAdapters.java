package com.vsevolodvisnevskij.homework.base;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.vsevolodvisnevskij.homework.hw9.CircleTransformation;

/**
 * Created by vsevolodvisnevskij on 14.03.2018.
 */

public class BindingAdapters {
    @BindingAdapter({"src", "error", "placeholder"})
    public static void loadImage(ImageView view, String url, Drawable err, Drawable placeholder) {
        if (url != null && url.length() > 0) {
            Picasso.with(view.getContext()).load(url).placeholder(placeholder).error(err).transform(new CircleTransformation()).into(view);
        }
    }
}
