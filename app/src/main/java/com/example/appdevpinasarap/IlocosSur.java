package com.example.appdevpinasarap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class IlocosSur extends AppCompatActivity {

    ImageButton backbtn_sur;
    Button btnilocos_empanada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilocos_sur);

        backbtn_sur = (ImageButton) findViewById(R.id.backbtn_pangasinan);
        btnilocos_empanada = (Button) findViewById(R.id.btnilocos_empanada);

        backbtn_sur.setOnClickListener(view -> {
           startActivity(new Intent(IlocosSur.this,RegionI.class));
        });

        btnilocos_empanada.setOnClickListener(view -> {
            startActivity(new Intent(IlocosSur.this,IlocosEmpanada.class));
        });

    }
}