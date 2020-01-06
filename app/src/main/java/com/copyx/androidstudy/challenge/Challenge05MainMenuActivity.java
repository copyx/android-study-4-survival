package com.copyx.androidstudy.challenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.copyx.androidstudy.R;

public class Challenge05MainMenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1001;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_05_main_menu);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v;
                Intent intent = new Intent();
                intent.putExtra("data", button.getText());
                setResult(RESULT_OK, intent);
                finish();
            }
        };

        findViewById(R.id.customer_management_button).setOnClickListener(listener);
        findViewById(R.id.sales_management_button).setOnClickListener(listener);
        findViewById(R.id.product_management_button).setOnClickListener(listener);
    }
}
