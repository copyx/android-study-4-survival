package com.copyx.androidstudy;

import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LinearLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(params);

        Button button7 = new Button(this);
        button7.setText("Button 7");
        button7.setLayoutParams(params);
        button7.setGravity(Gravity.LEFT | Gravity.TOP);
        linearLayout.addView(button7);

        Button button8 = new Button(this);
        button8.setText("Button 8");
        button8.setLayoutParams(params);
        button8.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
        linearLayout.addView(button8);

        LinearLayout innerLinearLayout = findViewById(R.id.inner_linear_layout);
        innerLinearLayout.addView(linearLayout);

//        setContentView(linearLayout);
    }
}
