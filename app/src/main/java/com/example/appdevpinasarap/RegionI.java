package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegionI extends AppCompatActivity {
    ImageButton backbtn_reg1;
    Button btnilocossur,btnilocosnorte,btn_launion,btn_pangasinan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_i);

        backbtn_reg1 = (ImageButton) findViewById(R.id.backbtn_pangasinan);
        btnilocossur = (Button) findViewById(R.id.btnilocossur);
        btnilocosnorte = (Button) findViewById(R.id.btnilocosnorte);
        btn_launion = (Button) findViewById(R.id.btn_launion);
        btn_pangasinan = (Button) findViewById(R.id.btn_pangasinan);

        backbtn_reg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegionI.this,Luzon.class));
            }
        });

        btnilocossur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegionI.this,IlocosSur.class));
            }
        });

        btnilocosnorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegionI.this,IlocosNorte.class));
            }
        });

        btn_launion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegionI.this,LaUnion.class));
            }
        });

        btn_pangasinan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegionI.this,Pangasinan.class));
            }
        });



    }
}