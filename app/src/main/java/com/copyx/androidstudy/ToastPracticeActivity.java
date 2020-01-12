package com.copyx.androidstudy;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class ToastPracticeActivity extends AppCompatActivity {
    EditText xEditText;
    EditText yEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_practice);

        xEditText = findViewById(R.id.toast_x_edit_text);
        yEditText = findViewById(R.id.toast_y_edit_text);

        findViewById(R.id.toast_ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast toastView = Toast.makeText(v.getContext(), "위치가 바뀐 토스트 메시지입니다.", Toast.LENGTH_LONG);

                    int xOffset = Integer.valueOf(xEditText.getText().toString());
                    int yOffset = Integer.valueOf(yEditText.getText().toString());

                    toastView.setGravity(Gravity.TOP|Gravity.START, xOffset, yOffset);
                    toastView.show();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.toast_another_style_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();

                View layout = inflater.inflate(R.layout.toastborder, (ViewGroup) findViewById(R.id.toast_layout_root));

                TextView textView = (TextView) layout.findViewById(R.id.text);

                Toast toast = new Toast(v.getContext());
                textView.setText("모양 바꾼 토스트");

                toast.setGravity(Gravity.CENTER, 0, -100);
                toast.setDuration(Toast.LENGTH_SHORT);

                toast.setView(layout);
                toast.show();
            }
        });

        findViewById(R.id.toast_snack_bar_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "스낵바입니다.", Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
