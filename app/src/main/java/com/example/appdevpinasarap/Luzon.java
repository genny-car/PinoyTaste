package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Luzon extends AppCompatActivity {

    Button btn_reg1;
    ImageButton backbtn_luzon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luzon);

        btn_reg1 = (Button) findViewById(R.id.btn_reg1);
        backbtn_luzon = (ImageButton) findViewById(R.id.backbtn_luzon);

        backbtn_luzon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Luzon.this,BottomNav.class));
            }
        });

        btn_reg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Luzon.this,RegionI.class));
            }
        });

    }
}