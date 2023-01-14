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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    //initialization
    Button btnsignup;
    ImageButton back_btn5;
    EditText txtfname,txtlname,txtuser, txtemail, txtpass;

    FirebaseUser user;
    FirebaseAuth mAuth;
    FirebaseDatabase db;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtfname = findViewById(R.id.txtfname);
        txtlname = findViewById(R.id.txtlname);
        txtuser = findViewById(R.id.txtuser);
        txtemail = findViewById(R.id.txtemail);
        txtpass = findViewById(R.id.txtpass);

        mAuth = FirebaseAuth.getInstance();
        btnsignup = (Button) findViewById(R.id.btnsignup);
        back_btn5 = (ImageButton) findViewById(R.id.back_btn5);


        back_btn5.setOnClickListener(view -> {
            startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
                });


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname = txtfname.getText().toString();
                String lname= txtlname.getText().toString();
                String email = txtuser.getText().toString();
                String username = txtemail.getText().toString();
                String password = txtpass.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    txtuser.setError("No Email Found");
                    txtuser.requestFocus();
                } else if (TextUtils.isEmpty(password)) {
                    txtpass.setError("No Password Found");
                    txtpass.requestFocus();
                } else if (TextUtils.isEmpty(username)) {
                    txtemail.setError("No Username Found");
                    txtemail.requestFocus();
                } else if (TextUtils.isEmpty(fname)) {
                    txtuser.setError("No First Name Found");
                    txtuser.requestFocus();
                } else if (TextUtils.isEmpty(lname)) {
                    txtuser.setError("No Last Name Found");
                    txtuser.requestFocus();
                }else {
                    mAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){user = FirebaseAuth.getInstance().getCurrentUser();
                               profdata prof = new profdata(fname,lname,username,email,password);
                               db.getInstance().getReference("profdata").child(user.getUid())
                                       .setValue(prof).addOnCompleteListener(new OnCompleteListener<Void>() {
                                           @Override
                                           public void onComplete(@NonNull Task<Void> task) {
                                               Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                               startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                                           }
                                       });
                            }else{
                                Toast.makeText(SignUpActivity.this, "Error has Occurred", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

        }
});
}
}


