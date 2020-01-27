package com.copyx.androidstudy;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

public class BitmapButton extends AppCompatButton {
    private int iconNormal = android.R.drawable.btn_star_big_on;
    private int iconClicked = android.R.drawable.btn_star_big_off;

    public static final int STATUS_NORMAL = 0;
    public static final int STATUS_CLICKED = 0;
    private int iconStatus = STATUS_NORMAL;

    public BitmapButton(Context context) {
        super(context);

        init();
    }

    // XML 레이아웃에서 버튼 추가시 사용되는 생성
    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        setBackgroundResource(iconNormal);

        int defaultTextColor = Color.WHITE;
        float defaultTextSize = getResources().getDimension(R.dimen.text_size);
        Typeface defaultTypeface = Typeface.DEFAULT_BOLD;

        setTextColor(defaultTextColor);
        setTextSize(defaultTextSize);
        setTypeface(defaultTypeface);
    }

    public void setIcon(int iconNormal, int iconClicked) {
        this.iconNormal = iconNormal;
        this.iconClicked = iconClicked;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                setBackgroundResource(this.iconClicked);
                iconStatus = STATUS_CLICKED;
                break;
            }
            case MotionEvent.ACTION_OUTSIDE:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP: {
                setBackgroundResource(this.iconNormal);
                iconStatus = STATUS_NORMAL;
                break;
            }
        }

        invalidate();

        return true;
    }
}
