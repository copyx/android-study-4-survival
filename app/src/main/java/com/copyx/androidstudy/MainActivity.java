package com.copyx.androidstudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivity";

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

        addButton("서비스 실습", ServicePracticeActivity.class);
        addButton("액티비티 수명주기", ActivityLifeCycleActivity.class);
        addButton("인텐트 실습", IntentPracticeActivity.class);
        addButton("액티비티 종료 응답 실습", SetResultActivity.class, 1000);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String toastMessage = String.format("RequestCode:%d/ResultCode:%d - Data: %s", requestCode, resultCode, data.getStringExtra("data"));
        Log.d(TAG, toastMessage);

        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    private void addButton(String buttonText, Class<?> cls) {
        Button button = new Button(this);

        button.setText(buttonText);
        button.setOnClickListener(new OnClickListenerToStartActivity(cls));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(layoutParams);

        buttonLinearLayout.addView(button);
    }

    private void addButton(String buttonText, Class<?> cls, int requestCode) {
        Button button = new Button(this);

        button.setText(buttonText);
        button.setOnClickListener(new OnClickListenerToStartActivityForResult(cls, requestCode));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(layoutParams);

        buttonLinearLayout.addView(button);
    }

    private class OnClickListenerToStartActivity implements View.OnClickListener {

        Class<?> cls;

        OnClickListenerToStartActivity(Class<?> cls) {
            this.cls = cls;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), cls);
            startActivity(intent);
        }
    }

    private class OnClickListenerToStartActivityForResult implements View.OnClickListener {

        Class<?> cls;
        int requestCode;

        OnClickListenerToStartActivityForResult(Class<?> cls, int requestCode) {
            this.cls = cls;
            this.requestCode = requestCode;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), cls);
            startActivityForResult(intent, requestCode);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent == null) {
            return;
        }

        String command = intent.getStringExtra("command");
        String data = intent.getStringExtra("data");

        Toast.makeText(this, "Command : " + command + ", data : " + data, Toast.LENGTH_LONG).show();
        super.onNewIntent(intent);
    }
}
