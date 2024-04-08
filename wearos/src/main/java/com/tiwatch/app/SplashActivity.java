package com.tiwatch.app;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> {

            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i/*, ActivityOptions.makeSceneTransitionAnimation(this).toBundle()*/);
            overridePendingTransition(R.anim.slide_in_right,
                    R.anim.slide_out_left);
            finish();
        }, SPLASH_TIME_OUT);
    }
}