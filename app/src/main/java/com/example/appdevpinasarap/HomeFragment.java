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


public class HomeFragment extends Fragment {
    Button luzon_btn,visayas_btn,mindanao_btn;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        luzon_btn = v.findViewById(R.id.luzon_btn);
        visayas_btn = v.findViewById(R.id.visayas_btn);
        mindanao_btn = v.findViewById(R.id.mindanao_btn);

        luzon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Luzon.class);
                startActivity(intent);
            }
        });

        final TextView txtviewhomename = (TextView) v.findViewById(R.id.txtviewhomename);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("profdata");
        userID = user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                profdata userProfile = snapshot.getValue(profdata.class);

                if(userProfile != null){
                    String name = userProfile.fname;

                    txtviewhomename.setText(name);
                }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return v;
    }
}