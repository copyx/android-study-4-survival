package com.copyx.androidstudy;

public class MonthItem {
    private int day;

    public MonthItem() {
    }

    public MonthItem(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public MonthItem setDay(int day) {
        this.day = day;
        return this;
    }
}
