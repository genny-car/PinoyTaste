package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    LottieAnimationView lottieprof;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lottieprof = findViewById(R.id.lottieprof);

        lottieprof.setOnClickListener(view -> {
            lottieprof.playAnimation();

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    startActivity(new Intent(HomeActivity.this,ProfileActivity .class));
                }
            }, 2000);

        });
    }

}