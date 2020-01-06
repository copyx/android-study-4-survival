package com.copyx.androidstudy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class TestService extends Service {
    private static final String TAG = "TestService";

    public TestService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate() called.");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() called.");

        if (intent == null) {
            return Service.START_STICKY;
        } else {
            processCommand(intent);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent) {
        String command = intent.getStringExtra("command");
        String data = intent.getStringExtra("data");

        Log.d(TAG, "command : " + command + ", data : " + data);

        if (data.equals("show")) {
            Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
            showIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    Intent.FLAG_ACTIVITY_SINGLE_TOP |
                    Intent.FLAG_ACTIVITY_CLEAR_TOP);
            showIntent.putExtra("command", "show");
            showIntent.putExtra("data", data + " from service.");
            startActivity(showIntent);
        } else {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {};
                Log.d(TAG, "Waiting " + i + " seconds.");
            }
        }

    }
}
