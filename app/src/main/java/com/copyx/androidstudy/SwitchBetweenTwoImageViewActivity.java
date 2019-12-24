package com.copyx.androidstudy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
    Solutions
    1. 버튼을 누를 때 마다 이미지를 원하는 위치에 로딩한다.(동적 생성으로 이미지뷰를 만든다)
    2. 두 개의 이미지뷰를 만들어서 버튼을 누르면 Visibility만 끄고 켠다.
    3. 이미지뷰를 하나 만들어서 이미지를 로드하고, 이미지뷰의 위치를 바꾼다.

    세 번째 솔루션이 이미지를 로드하거나 유지하는데 드는 리소스가 가장 적게들어서 선택!

    이미지뷰를 각 스크롤뷰로 옮기려면
 */
public class SwitchBetweenTwoImageViewActivity extends AppCompatActivity {

    ImageView imageView;
    HorizontalScrollView topHorizontalScrollView;
    HorizontalScrollView bottomHorizontalScrollView;
    Button switchButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_between_two_image_view);

        imageView = findViewById(R.id.image_view);
        topHorizontalScrollView = findViewById(R.id.top_horizontal_scroll_view);
        bottomHorizontalScrollView = findViewById(R.id.bottom_horizontal_scroll_view);
        switchButton = findViewById(R.id.switch_button);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageView.getParent().equals(topHorizontalScrollView)) {
                    topHorizontalScrollView.removeView(imageView);
                    bottomHorizontalScrollView.addView(imageView);
                } else {
                    bottomHorizontalScrollView.removeView(imageView);
                    topHorizontalScrollView.addView(imageView);
                }
            }
        });
    }
}
