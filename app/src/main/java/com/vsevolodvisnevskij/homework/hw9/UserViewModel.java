package com.vsevolodvisnevskij.homework.hw9;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by vsevolodvisnevskij on 07.03.2018.
 */

public class UserViewModel extends BaseObservable {
    private User user;
    private boolean loaded = false;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        loaded = true;
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

    @Bindable
    public boolean isLoaded() {
        return loaded;
    }

}
