package com.copyx.androidstudy;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TouchGestureKeyEventActivity extends AppCompatActivity {
    View blueView;
    View orangeView;
    TextView bottomTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);

        blueView = findViewById(R.id.blue_view);
        orangeView = findViewById(R.id.orange_view);
        bottomTextView = findViewById(R.id.bottom_textview);

        blueView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                float curX = event.getX();
                float curY = event.getY();

                if (action == MotionEvent.ACTION_DOWN) {
                    bottomTextView.append("손가락 눌림 : " + curX + ", " + curY + "\n");
                } else if (action == MotionEvent.ACTION_MOVE) {
                    bottomTextView.append("손가락 움직임 : " + curX + ", " + curY + "\n");
                } else if (action == MotionEvent.ACTION_UP) {
                    bottomTextView.append("손가락 뗌 : " + curX + ", " + curY + "\n");
                }

                return true;
            }
        });

        final GestureDetector detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                bottomTextView.append("onDown() called.\n");

                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                bottomTextView.append("onShowPress() called.\n");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                bottomTextView.append("onSingleTapUp() called.\n");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                bottomTextView.append("onScroll() called : " + distanceX + ", " + distanceY + "\n");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                bottomTextView.append("onLongPress() called.\n");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                bottomTextView.append("onFling() called.\n");
                return true;
            }
        });

        orangeView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "Back button pushed.", Toast.LENGTH_SHORT).show();
//            return true;  // 조상 클래스인 Activity 클래스에서 호출하던 onBackPressed()를 안하게 됨
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "onBackPressed() called.", Toast.LENGTH_SHORT).show();
    }
}
