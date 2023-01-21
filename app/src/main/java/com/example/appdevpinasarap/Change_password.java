package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Change_password extends AppCompatActivity {


    Button btnchangepass;
    EditText txtcurrpass,txtnewpass,txtconpass;

    String UserID;
    FirebaseAuth zAuth;
    FirebaseUser user;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        btnchangepass = (Button) findViewById(R.id.btnchangepass);
        txtcurrpass = (EditText) findViewById(R.id.txtcurrpass);
        txtnewpass = (EditText) findViewById(R.id.txtnewpass);
        txtconpass = (EditText) findViewById(R.id.txtconpass);

        zAuth = FirebaseAuth.getInstance();
        UserID = zAuth.getCurrentUser().getUid();
        user = zAuth.getCurrentUser();



        btnchangepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePass();
            }
        });
    }
public void changePass() {
    String txtcurrentpass = txtcurrpass.getText().toString();
    String txtnewpassword = txtnewpass.getText().toString();
    String txtconfirmpass = txtconpass.getText().toString();

    if (TextUtils.isEmpty(txtcurrentpass)) {
        txtcurrpass.setError("Please Enter Your Current Password!");
        txtcurrpass.requestFocus();
        return;
    } else if (TextUtils.isEmpty(txtnewpassword)) {
        txtnewpass.setError("Please Enter Your New Password!");
        txtnewpass.requestFocus();
        return;
    } else if (TextUtils.isEmpty(txtconfirmpass)) {
        txtconpass.setError("Please Confirm Your New Password!");
        txtconpass.requestFocus();
        return;
    }  else if (!txtnewpassword.equals(txtconfirmpass)){
        txtnewpass.setError("Password Do Not Match!");
        txtnewpass.requestFocus();
        return;
    }
        user.updatePassword(txtnewpassword).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                txtcurrpass.setText("");
                txtnewpass.setText("");
                txtconpass.setText("");
                Toast.makeText(Change_password.this, "Password Changed Successfully", Toast.LENGTH_SHORT).show();
                update(txtnewpassword);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Change_password.this, "Error has Occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void update(String txtnewpassword){
        HashMap nUpdate =new HashMap();

        nUpdate.put("password",txtnewpassword);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("profdata");
        reference.child(user.getUid()).updateChildren(nUpdate).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()){
                }
                }
            });
    }
}

