package com.copyx.androidstudy;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AnimationPracticeActivity extends AppCompatActivity {
    TextView animationTextView;
    Animation flowAnim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_practice);

        animationTextView = findViewById(R.id.animation_text_view);
        flowAnim = AnimationUtils.loadAnimation(this, R.anim.flow);
        flowAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Started.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });

        findViewById(R.id.animation_start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationTextView.startAnimation(flowAnim);
            }
        });
    }
}
