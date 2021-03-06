package com.copyx.androidstudy;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class MonthItemView extends AppCompatTextView {
    private MonthItem item;

    public MonthItemView(Context context) {
        super(context);
        init();
    }

    public MonthItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setBackgroundColor(Color.WHITE);
    }

    public MonthItem getItem() {
        return item;
    }

    public MonthItemView setItem(MonthItem item) {
        this.item = item;

        int day = item.getDay();

        if (day != 0) {
            setText(String.valueOf(day));
        } else {
            setText("");
        }

        return this;
    }
}
