package com.copyx.androidstudy;

public class SingerItem {
    String name;
    String mobile;
    int age;
    int resId;

    public SingerItem(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public SingerItem(String name, String mobile, int age, int resId) {
        this.name = name;
        this.mobile = mobile;
        this.age = age;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public SingerItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public SingerItem setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public int getAge() {
        return age;
    }

    public SingerItem setAge(int age) {
        this.age = age;
        return this;
    }

    public int getResId() {
        return resId;
    }

    public SingerItem setResId(int resId) {
        this.resId = resId;
        return this;
    }
}
