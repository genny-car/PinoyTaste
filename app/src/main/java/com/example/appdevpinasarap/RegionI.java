package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegionI extends AppCompatActivity {
    ImageButton backbtn_reg1;
    Button btnilocossur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_i);

        backbtn_reg1 = (ImageButton) findViewById(R.id.backbtn_reg1);
        btnilocossur = (Button) findViewById(R.id.btnilocossur);

        backbtn_reg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegionI.this,Luzon.class));
            }
        });

        btnilocossur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegionI.this,ViganLongganisa.class));
            }
        });


    }
}