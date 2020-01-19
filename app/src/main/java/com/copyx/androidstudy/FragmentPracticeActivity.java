package com.copyx.androidstudy;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FragmentPracticeActivity extends AppCompatActivity {
    private static final String TAG = "FragmentPracticeActivity";
    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_practice);

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_main);
        menuFragment = new MenuFragment();
    }

    public void onFragmentChanged(int index) {
        Log.d(TAG, "onFragmentChanged called with index : " + index);

        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
        }
    }
}
