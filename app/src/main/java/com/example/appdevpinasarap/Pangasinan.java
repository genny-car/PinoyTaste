package com.example.appdevpinasarap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Pangasinan extends AppCompatActivity {

    ImageButton backbtn_pangasinan;
    Button btnpigar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pangasinan);

        backbtn_pangasinan = (ImageButton) findViewById(R.id.backbtn_pangasinan);
        btnpigar = (Button) findViewById(R.id.btnpigar);

        backbtn_pangasinan.setOnClickListener(view -> {
           startActivity(new Intent(Pangasinan.this,RegionI.class));
        });

        btnpigar.setOnClickListener(view -> {
           startActivity(new Intent(Pangasinan.this,PigarPigar.class));
        });
    }
}