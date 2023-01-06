package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AfterSplashScreen extends AppCompatActivity {

    Button button7, button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_splash_screen);

        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);

        button7.setOnClickListener(view -> {
            startActivity(new Intent(AfterSplashScreen.this, SignInActivity.class));
        });

        button8.setOnClickListener(view -> {
            startActivity(new Intent(AfterSplashScreen.this, SignUpActivity.class));
        });
    }
}