package com.copyx.androidstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ServicePracticeActivity extends AppCompatActivity {
    EditText serviceInputEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_practice);

        serviceInputEditText = findViewById(R.id.service_input_edit_text);

        findViewById(R.id.start_service_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TestService.class);
                intent.putExtra("command", "show");
                intent.putExtra("data", serviceInputEditText.getText().toString());
                startService(intent);
            }
        });
    }
}
