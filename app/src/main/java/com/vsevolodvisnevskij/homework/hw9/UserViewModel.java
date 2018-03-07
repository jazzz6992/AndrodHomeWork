package com.vsevolodvisnevskij.homework.hw9;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * Created by vsevolodvisnevskij on 07.03.2018.
 */

public class UserViewModel extends BaseObservable {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        notifyChange();
    }

    @Bindable
    public String getUserName() {
        if (user != null) {
            return user.getName();
        }
        return null;
    }

    @Bindable
    public String getUserAge() {
        if (user != null) {
            return String.valueOf(user.getAge());
        }
        return null;
    }

    @Bindable
    public Boolean getUserGender() {
        if (user != null) {
            return user.isGender();
        }
        return null;
    }

    @Bindable
    public String getUserImgUrl() {
        if (user != null) {
            return user.getImgUrl();
        }
        return null;
    }

    @BindingAdapter({"android:src", "android:error"})
    public static void loadImage(ImageView view, String url, Drawable err) {
        Picasso.with(view.getContext()).load(url).error(err).transform(new CircleTransformation()).into(view);
    }
}
