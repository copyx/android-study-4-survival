package com.copyx.androidstudy;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/*
 * 화면 방향 전환을 처리하는 두 가지 방법
 * 1. 액티비티를 재생성하고, 각 방향에 맞는 레이아웃 사용 및 데이터 저장/복원
 * 2. 액티비티는 그대로 사용하고 화면이 바뀌었다는 이벤트를 액티비티에서 처리하는 방법 (매니페스트 설정 필요)
 */
public class OrientationActivity extends AppCompatActivity {
    private final String TAG = "OrientationActivity";

    EditText orientationEditText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called.");

        setContentView(R.layout.activity_orientation);

        orientationEditText = findViewById(R.id.orientation_edit_text);

        if (savedInstanceState != null) {
            String name = savedInstanceState.getString("name", "");
            Toast.makeText(this, "Value of name is restored. : " + name, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called.");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        
        String name = orientationEditText.getText().toString();
        outState.putString("name", name);
        Toast.makeText(this, "Value of name is saved. : " + name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged() called.");

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d(TAG, "Orientation: landscape");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d(TAG, "Orientation: portrait");
        }
    }
}
