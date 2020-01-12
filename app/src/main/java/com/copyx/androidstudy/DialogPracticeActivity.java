package com.copyx.androidstudy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DialogPracticeActivity extends AppCompatActivity {
    TextView resultTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_practice);

        resultTextView = findViewById(R.id.dialog_result_text_view);

        findViewById(R.id.dialog_show_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Info.");
                builder.setMessage("Do you want to quit?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resultTextView.setText("Yes, I do.");
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resultTextView.setText("No, I don't.");
                    }
                });

                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resultTextView.setText("Canceled.");
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
