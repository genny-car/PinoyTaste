package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class IlocosNorte extends AppCompatActivity {

    ImageButton backbtn_norte;
    Button btn_longganisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilocos_norte);

        backbtn_norte = (ImageButton) findViewById(R.id.backbtn_pangasinan);
        btn_longganisa = (Button) findViewById(R.id.btnpigar);

        btn_longganisa.setOnClickListener(view ->{
            startActivity(new Intent(IlocosNorte.this,ViganLongganisa.class));
        });

        backbtn_norte.setOnClickListener(view -> {
           startActivity(new Intent(IlocosNorte.this, RegionI.class));
        });
    }
}