package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appdevpinasarap.databinding.ActivityHomeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Edit_Profile extends AppCompatActivity {

    Button editbtnsave;
    ImageButton back_btn1;
    DatabaseReference reference;
    EditText txteditfname,txteditlname,txteditusername;

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editbtnsave = (Button) findViewById(R.id.editbtnsave);
        back_btn1 = (ImageButton) findViewById(R.id.back_btn1);

        txteditfname = (EditText) findViewById(R.id.txteditfname);
        txteditlname = (EditText) findViewById(R.id.txteditlname);
        txteditusername = (EditText) findViewById(R.id.txteditusername);

        back_btn1.setOnClickListener(view -> {
           startActivity(new Intent(Edit_Profile.this, BottomNav.class));
        });

        editbtnsave.setOnClickListener(view -> {
            String editfname = txteditfname.getText().toString();
            String editlname = txteditlname.getText().toString();
            String editusername = txteditusername.getText().toString();
            update(editfname,editlname,editusername);


        });

    }
    private void update(String editfname, String editlname, String editusername){
        HashMap nUpdate =new HashMap();

        nUpdate.put("fname",editfname);
        nUpdate.put("lname",editlname);
        nUpdate.put("username",editusername);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("profdata");
        reference.child(user.getUid()).updateChildren(nUpdate).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()){
                    txteditfname.setText("");
                    txteditlname.setText("");
                    txteditusername.setText("");
                    Toast.makeText(Edit_Profile.this,"Updated",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Edit_Profile.this,"Failed to Update",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}