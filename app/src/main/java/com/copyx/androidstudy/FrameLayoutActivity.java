package com.copyx.androidstudy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FrameLayoutActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    Button changeButton;

    ArrayList<View> childrenList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_frame_layout);
        frameLayout = findViewById(R.id.frame_layout);
        changeButton = findViewById(R.id.change_button);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        for (int i = 0; i < frameLayout.getChildCount(); i++) {
            childrenList.add(frameLayout.getChildAt(i));
        }

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextView();
            }
        });
    }

    private void showNextView() {
        for (int i = 0; i < childrenList.size(); i++) {
            View view = childrenList.get(i);
            if (view.getVisibility() != View.GONE) {
                view.setVisibility(View.GONE);
                childrenList.get((i + 1) % childrenList.size()).setVisibility(View.VISIBLE);
                break;
            }
        }
    }
}
