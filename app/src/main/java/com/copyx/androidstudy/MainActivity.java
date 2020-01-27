package com.copyx.androidstudy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.copyx.androidstudy.challenge.Challenge05LoginActivity;
import com.copyx.androidstudy.challenge.CountLettersInSMSInputScreen;
import com.copyx.androidstudy.challenge.SwitchBetweenTwoImageViewActivity;
import com.copyx.androidstudy.challenge.TopMiddleBottomButtonsActivity;
import com.copyx.androidstudy.challenge.TwoButtonsOnBottomActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivity";

    private LinearLayout buttonLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLinearLayout = findViewById(R.id.button_linear_layout);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "SMS 수신 권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "SMS 수신 권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS)) {
                Toast.makeText(this, "SMS 권한 설명 필요함", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECEIVE_SMS}, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "SMS 권한을 사용자가 승인함", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "SMS 권한 거부됨", Toast.LENGTH_LONG).show();
                }
                break;
            }
            default: {
                Log.d(TAG, "Unknown request code. : " + requestCode);
            }
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        addButton("그리드뷰 실습", GridViewPracticeActivity.class);
        addButton("스피너 실습", SpinnerPracticeActivity.class);
        addButton("리스트뷰 실습", ListViewPracticeActivity.class);
        addButton("비트맵 버튼 실습", BitmapButtonActivity.class);
        addButton("나인패치 실습", NinePatchPracticeActivity.class);

        addButton("InputType에 따른 키패드 변화 실습", KeypadPracticeActivity.class);
        addButton("웹뷰 실습", WebViewPracticeActivity.class);
        addButton("탭 구현 실습", TabPracticeActivity.class);
        View view = addButton("컨텍스트 메뉴 실습(길게 누르세요)", null);
        registerForContextMenu(view);
        addButton("한 액티비티에 두 개의 프래그먼트 실습", TwoFragmentInOneActivity.class);
        addButton("프래그먼트 실습", FragmentPracticeActivity.class);
        addButton("페이지 슬라이딩 실습", PageSlidingActivity.class);
        addButton("애니메이션 실습", AnimationPracticeActivity.class);

        addButton("프로그레스바 & 시크바 실습", ProgressBarPracticeActivity.class);
        addButton("알림 대화상자 실습", DialogPracticeActivity.class);
        addButton("토스트 & 스낵바 실습", ToastPracticeActivity.class);
        addButton("화면 방향전환 이벤트 처리 실습", OrientationActivity.class);
        addButton("포커스 이벤트 처리 실습", FocusEventActivity.class);
        addButton("터치/제스쳐/키 이벤트 처리 실습", TouchGestureKeyEventActivity.class);

        addButton("도전 05. 로그인 화면과 메뉴 화면 전환하기", Challenge05LoginActivity.class);
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

        String dataString = data != null ? data.getStringExtra("data") : "";
        String message = String.format(Locale.KOREA, "RequestCode:%d/ResultCode:%d - Data: %s", requestCode, resultCode, dataString);
        Log.d(TAG, message);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private View addButton(String buttonText, Class<?> cls) {
        Button button = new Button(this);

        button.setText(buttonText);
        button.setOnClickListener(new OnClickListenerToStartActivity(cls));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(layoutParams);

        buttonLinearLayout.addView(button);

        return button;
    }

    private View addButton(String buttonText, Class<?> cls, int requestCode) {
        Button button = new Button(this);

        button.setText(buttonText);
        button.setOnClickListener(new OnClickListenerToStartActivityForResult(cls, requestCode));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(layoutParams);

        buttonLinearLayout.addView(button);

        return button;
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
            if (cls == null) {
                return;
            }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        View view = menu.findItem(R.id.menu_search).getActionView();

        if (view != null) {
            EditText editText = view.findViewById(R.id.edit_text);

            if (editText != null) {
                editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        Toast.makeText(v.getContext(), "Search : " + v.getText(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }
        }

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d(TAG, "onPrepareOptionsMenu");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_refresh:
                Toast.makeText(this, "Refresh menu is selected.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search:
                Toast.makeText(this, "Search menu is selected.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(this, "Settings menu is selected.", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        onOptionsItemSelected(item);
        return super.onContextItemSelected(item);
    }
}
