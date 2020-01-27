package com.copyx.androidstudy;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CompositeWidgetPracticeActivity extends AppCompatActivity {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    TextView textView;
    DateTimePicker dateTimePicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composite_widget_practice);

        textView = findViewById(R.id.textView);
        dateTimePicker = findViewById(R.id.dateTimePicker);

        dateTimePicker.setOnDateTimeChagedListener(new DateTimePicker.OnDateTimeChangedListener() {
            @Override
            public void onDateTimeChanged(DateTimePicker view, int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minute) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth, hourOfDay, minute);

                textView.setText(dateFormat.format(calendar.getTime()));
            }
        });

        Calendar calendar = Calendar.getInstance();
        calendar.set(dateTimePicker.getYear(), dateTimePicker.getMonthOfYear(), dateTimePicker.getDayOfMonth(), dateTimePicker.getCurrentHour(), dateTimePicker.getCurrentMinute());
        textView.setText(dateFormat.format(calendar.getTime()));
    }
}
