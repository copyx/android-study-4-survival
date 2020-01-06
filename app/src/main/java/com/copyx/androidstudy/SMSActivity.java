package com.copyx.androidstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SMSActivity extends AppCompatActivity {

    EditText smsSenderEditText;
    EditText smsContentsEditText;
    EditText smsReceivedDateEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        smsSenderEditText = findViewById(R.id.sms_sender_edittext);
        smsContentsEditText = findViewById(R.id.sms_contents_edittext);
        smsReceivedDateEditText = findViewById(R.id.sms_received_date_edittext);

        findViewById(R.id.sms_ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        processIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent) {
        if (intent == null) {
            return;
        }

        smsSenderEditText.setText(intent.getStringExtra("sender"));
        smsContentsEditText.setText(intent.getStringExtra("contents"));
        smsReceivedDateEditText.setText(intent.getStringExtra("receivedDate"));
    }
}
