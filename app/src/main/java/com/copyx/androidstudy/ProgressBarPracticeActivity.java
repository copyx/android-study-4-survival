package com.copyx.androidstudy;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProgressBarPracticeActivity extends AppCompatActivity {
    private static final String TAG = "ProgressBarPracticeActivity";
    ProgressDialog progressDialog;

    View seekBarPanel;
    SeekBar seekBar;
    TextView seekBarTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_practice);

        final ProgressBar progressBar = findViewById(R.id.progress_bar);
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgress(80);

        findViewById(R.id.progress_bar_show_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(v.getContext()  );
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("데이터를 확인 중입니다.");
                progressDialog.show();
            }
        });

        findViewById(R.id.progress_bar_close_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            }
        });

        seekBarPanel = findViewById(R.id.seek_bar_panel);
        seekBar = findViewById(R.id.seek_bar);
        seekBarTextView = findViewById(R.id.seek_bar_progress_text_view);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        Log.d(TAG, "Window.screenBrightness : " + params.screenBrightness);

        int defaultBrightness = (int)(params.screenBrightness * 100);
        seekBar.setProgress(defaultBrightness);
        seekBarTextView.setText("SeekBar progress : " + defaultBrightness);

        findViewById(R.id.seek_bar_show_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBarPanel.setVisibility(View.VISIBLE);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setBrightness(progress);
                seekBarTextView.setText("SeekBar progress : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setBrightness(int value) {
        if (value < 10) {
            value = 10;
        } else if (value > 100) {
            value = 100;
        }

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = (float) value / 100;
        getWindow().setAttributes(params);
    }
}
