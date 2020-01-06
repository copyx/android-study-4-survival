package com.copyx.androidstudy.challenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.copyx.androidstudy.R;

public class Challenge05LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_05_login);

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Challenge05MainMenuActivity.class);
                startActivityForResult(intent, Challenge05MainMenuActivity.REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String selectedMenu = data.getStringExtra("data");
        Toast.makeText(this, "Selected menu : " + selectedMenu, Toast.LENGTH_SHORT).show();
    }
}
