package com.copyx.androidstudy;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.copyx.androidstudy.data.Something;

import java.io.File;

public class IntentPracticeActivity extends AppCompatActivity {
    EditText phoneNumberEditText;
    EditText websiteUrlEditText;
    EditText pdfFilenameEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_practice);

        phoneNumberEditText = findViewById(R.id.phone_number_edit_text);
        websiteUrlEditText = findViewById(R.id.website_url_edit_text);
        pdfFilenameEditText = findViewById(R.id.pdf_filename_edit_text);

        findViewById(R.id.call_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = phoneNumberEditText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(data));
                // ACTION_VIEW 로 인텐트 셋팅해도 다이얼이 뜬다!
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));

                startActivity(intent);
            }
        });

        findViewById(R.id.go_website_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = websiteUrlEditText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));

                startActivity(intent);
            }
        });

        findViewById(R.id.specific_component_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                ComponentName name = new ComponentName("com.copyx.androidstudy", "com.copyx.androidstudy.InflationActivity");
                intent.setComponent(name);

                startActivity(intent);
            }
        });

        findViewById(R.id.open_pdf_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sdCardPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                String pdfPath = sdCardPath + File.separator + pdfFilenameEditText.getText().toString();
                File sdCardFile = new File(sdCardPath);
                File list[] = sdCardFile.listFiles();

                for (File file: list) {
                    Log.d("IntentPracticeActivity", "In SDCard: " + file.getPath());
                }

                File file = new File(pdfPath);

                if (file.exists()) {
                    Uri uri = Uri.fromFile(file);

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(uri, "application/pdf");

                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException ex) {
                        Toast.makeText(v.getContext(), "PDF 뷰어 앱이 없...", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(v.getContext(), "PDF 파일이 없...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.pass_parcelable_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PassingParcelableActivity.class);
                Something data = new Something(1592, "임진왜란");
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });
    }
}
