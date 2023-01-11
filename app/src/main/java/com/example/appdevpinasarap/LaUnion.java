package com.example.appdevpinasarap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class LaUnion extends AppCompatActivity {

    ImageButton backbtn_launion;
    Button btniloko;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_la_union);

        backbtn_launion = (ImageButton) findViewById(R.id.backbtn_launion);
        btniloko = (Button) findViewById(R.id.btniloko);

        backbtn_launion.setOnClickListener(view -> {
            startActivity(new Intent(LaUnion.this,RegionI.class));
        });

        btniloko.setOnClickListener(view -> {
            startActivity(new Intent(LaUnion.this,IlokoHaloHalo.class));
        });
    }
}