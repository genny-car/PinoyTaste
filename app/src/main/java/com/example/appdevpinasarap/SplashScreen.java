package com.example.appdevpinasarap;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    ProgressBar progressBar;
    TextView loadingtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progressBar);
        loadingtxt = findViewById(R.id.loadingtxt);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnimation();

    }
    public void progressAnimation(){
        LoadingScreenAnimation anim = new LoadingScreenAnimation(this, progressBar, loadingtxt, 0f, 100f);
        anim.setDuration(5000);
        progressBar.setAnimation(anim);

    }

}

