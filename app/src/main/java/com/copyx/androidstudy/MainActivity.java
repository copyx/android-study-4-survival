package com.copyx.androidstudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        this.findViewById(R.id.challenge_01_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TwoButtonsOnBottomActivity.class);
                startActivity(intent);
            }
        });

        this.findViewById(R.id.challenge_02_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TopMiddleBottomButtonsActivity.class);
                startActivity(intent);
            }

        });

        this.findViewById(R.id.challenge_03_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LinearLayoutActivity.class);
                startActivity(intent);
            }

        });

        this.findViewById(R.id.challenge_04_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RelativeLayoutActivity.class);
                startActivity(intent);
            }

        });

        this.findViewById(R.id.challenge_05_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TableLayoutActivity.class);
                startActivity(intent);
            }

        });
    }
}
