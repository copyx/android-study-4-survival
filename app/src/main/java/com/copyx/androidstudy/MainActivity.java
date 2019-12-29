package com.copyx.androidstudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout buttonLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLinearLayout = findViewById(R.id.button_linear_layout);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        addButton("인플레이션 실습", InflationActivity.class);
        addButton("텍스트 속성 테스터", TextAttributeTesterActivity.class);
        addButton("도전 04. SMS 입력 화면 만들고 글자 수 표시하기", CountLettersInSMSInputScreen.class);
        addButton("도전 03. 두 개의 이미지뷰에 이미지 번갈아 보여주기", SwitchBetweenTwoImageViewActivity.class);
        addButton("FrameLayout 실습", FrameLayoutActivity.class);
        addButton("TableLayout 실습", TableLayoutActivity.class);
        addButton("RelativeLayout 실습", RelativeLayoutActivity.class);
        addButton("LinearLayout 실습", LinearLayoutActivity.class);
        addButton("도전 02. 위, 아래, 중앙의 공간을 차지하는 전형적인 화면 구성하기", TopMiddleBottomButtonsActivity.class);
        addButton("도전 01. 새 프로젝트 아래쪽에 두 개의 버튼 추가하기", TwoButtonsOnBottomActivity.class);
    }

    private void addButton(String buttonText, Class<?> cls) {
        // 버튼 만들고
        Button button = new Button(this);

        button.setText(buttonText);
        button.setOnClickListener(new OnClickListener(cls));

        // 레이아웃 관련 속성 채우고
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(layoutParams);

        // 레이아웃에 넣고
        buttonLinearLayout.addView(button);
    }

    private class OnClickListener implements View.OnClickListener {

        Class<?> cls;

        OnClickListener(Class<?> cls) {
            this.cls = cls;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), cls);
            startActivity(intent);
        }
    }
}
