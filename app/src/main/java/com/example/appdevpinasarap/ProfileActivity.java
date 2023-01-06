package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {
    Button btnlogout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnlogout = (Button) findViewById(R.id.btnlogout);
        mAuth = FirebaseAuth.getInstance();

        btnlogout.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(ProfileActivity.this, SplashScreen.class));
        });
    }
}