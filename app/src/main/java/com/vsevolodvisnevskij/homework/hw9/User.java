package com.vsevolodvisnevskij.homework.hw9;

/**
 * Created by vsevolodvisnevskij on 07.03.2018.
 */

public class User {
    private String imgUrl;
    private String name;
    private int age;
    private boolean gender;

    public User(String imgUrl, String name, int age, boolean gender) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
