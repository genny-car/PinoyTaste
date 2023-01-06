package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity extends AppCompatActivity {

    Button signinbtn, registerbtn, forgotpass;
    EditText emailt, passwordt;

    FirebaseDatabase database;
    private FirebaseAuth nAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailt = findViewById(R.id.emailt);
        passwordt = findViewById(R.id.passwordt);

        signinbtn = (Button) findViewById(R.id.signinbtn);
        registerbtn = (Button) findViewById(R.id.registerbtn);
        forgotpass = (Button) findViewById(R.id.forgotpass);
        nAuth = FirebaseAuth.getInstance();

        signinbtn.setOnClickListener(view -> {
            loginUser();
        });
        registerbtn.setOnClickListener(view -> {
            startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
        });
        forgotpass.setOnClickListener(view -> {
            startActivity(new Intent(SignInActivity.this, forgot_password.class));
        });
    }



    private void loginUser() {

        String email = emailt.getText().toString();
        String password = passwordt.getText().toString();

        if (TextUtils.isEmpty(email)) {
            emailt.setError("No Email Found");
            emailt.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            passwordt.setError("No Password Found");
            passwordt.requestFocus();
        } else {
            nAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignInActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignInActivity.this, BottomNav.class));
                    } else {
                        Toast.makeText(SignInActivity.this, "Log In Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}