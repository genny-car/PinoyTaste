package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_password extends AppCompatActivity {

    Button back_btn3,btnsendver;
    EditText txtveremail;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        back_btn3 = (Button) findViewById(R.id.back_btn3);
        btnsendver = (Button) findViewById(R.id.btnsendver);
        txtveremail = (EditText) findViewById(R.id.txtveremail);

        auth = FirebaseAuth.getInstance();


        back_btn3.setOnClickListener(view -> {
            startActivity(new Intent(forgot_password.this, SignInActivity.class));
        });

        btnsendver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passReset();
            }
        });
    }
    private void passReset(){

        String emailtxt = txtveremail.getText().toString().trim();

        if(TextUtils.isEmpty(emailtxt)){
            txtveremail.setError("No Email Found");
            txtveremail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailtxt).matches()){
           txtveremail.setError("Please provide a valid email");
           txtveremail.requestFocus();
           return;
        }
        auth.sendPasswordResetEmail(emailtxt).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(forgot_password.this,"Please check you email for verification",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(forgot_password.this,"Error has Occurred",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}