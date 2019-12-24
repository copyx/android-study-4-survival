package com.copyx.androidstudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        this.findViewById(R.id.linear_layout_practice_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LinearLayoutActivity.class);
                startActivity(intent);
            }

        });

        this.findViewById(R.id.relative_layout_practice_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RelativeLayoutActivity.class);
                startActivity(intent);
            }

        });

        this.findViewById(R.id.table_layout_practice_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TableLayoutActivity.class);
                startActivity(intent);
            }

        });

        this.findViewById(R.id.frame_layout_practice_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FrameLayoutActivity.class);
                startActivity(intent);
            }

        });

        this.findViewById(R.id.challenge_03_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SwitchBetweenTwoImageViewActivity.class);
                startActivity(intent);
            }
        });

        this.findViewById(R.id.challenge_04_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CountLettersInSMSInputScreen.class);
                startActivity(intent);
            }

        });

        this.findViewById(R.id.text_attribute_tester_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TextAttributeTesterActivity.class);
                startActivity(intent);
            }

        });

        this.findViewById(R.id.inflation_practice_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InflationActivity.class);
                startActivity(intent);
            }

        });
    }
}
