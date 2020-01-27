package com.copyx.androidstudy;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MultiTouchImageViewActivity extends AppCompatActivity {
    LinearLayout viewerContainer;
    ImageDisplayView displayView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_touch_image_view);

        init();
    }

    private void init() {
        viewerContainer = findViewById(R.id.viewerContainer);
        Bitmap sourceBitmap = loadImage();
        if (sourceBitmap != null) {
            displayView = new ImageDisplayView(this);

            displayView.setImageData(sourceBitmap);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);

            viewerContainer.addView(displayView, params);
        }
    }

    private Bitmap loadImage() {
        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.burger);

        return bitmap;
    }
}
