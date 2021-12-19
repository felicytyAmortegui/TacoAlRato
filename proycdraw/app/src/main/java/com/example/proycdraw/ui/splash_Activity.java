package com.example.proycdraw.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.proycdraw.MainActivity;
import com.example.proycdraw.R;

public class splash_Activity extends AppCompatActivity {
    private final int DURACION_SPLASH =5000;
    private ProgressBar progressBar, progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressBar2.incrementProgressBy(20);
            }
        };
        for(int i=0; i<5; i++){
            new Handler().postDelayed(runnable,(i+1)*1000);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(splash_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}