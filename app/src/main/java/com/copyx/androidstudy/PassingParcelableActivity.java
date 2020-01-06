package com.copyx.androidstudy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.copyx.androidstudy.data.Something;

public class PassingParcelableActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_parcelable);

        Intent intent = getIntent();

        if (intent != null) {
            Bundle bundle = intent.getExtras();
            Something data = bundle.getParcelable("data");
            ((TextView) findViewById(R.id.number_in_parcelable_textview)).setText(String.valueOf(data.getNumber()));
            ((TextView) findViewById(R.id.message_in_parcelable_textview)).setText(data.getMessage());
        }
    }
}
