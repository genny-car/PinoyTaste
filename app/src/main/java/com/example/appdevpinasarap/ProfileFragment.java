package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class ProfileFragment extends Fragment {
    Button change_pass_btn, edit_btn4, log_out_btn;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    public ProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        change_pass_btn = v.findViewById(R.id.change_pass_btn);
        edit_btn4 = v.findViewById(R.id.edit_btn4);
        log_out_btn = v.findViewById(R.id.log_out_btn);

        change_pass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Change_password.class);
                startActivity(intent);
            }
        });

        edit_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Edit_Profile.class);
                startActivity(intent);
            }
        });

        log_out_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SplashScreen.class);
                startActivity(intent);
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("profdata");
        userID = user.getUid();

        final TextView fullnametxtview = (TextView) v.findViewById(R.id.fullName);
        final TextView fnametxtview = (TextView) v.findViewById(R.id.firstName);
        final TextView lnametxtview = (TextView) v.findViewById(R.id.lastName);
        final TextView unametxtview = (TextView) v.findViewById(R.id.uname);
        final TextView uemailtxtview = (TextView) v.findViewById(R.id.uemail);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                profdata userProfile = snapshot.getValue(profdata.class);

                if(userProfile != null){
                    String fname = userProfile.fname;
                    String lname = userProfile.lname;
                    String username = userProfile.username;
                    String email = userProfile.email;

                    fullnametxtview.setText(fname + " " +lname);
                    fnametxtview.setText(fname);
                    lnametxtview.setText(lname);
                    unametxtview.setText(username);
                    uemailtxtview.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return v;
    }
}