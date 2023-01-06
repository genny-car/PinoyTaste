package com.example.appdevpinasarap;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {
    Button luzon_btn,visayas_btn,mindanao_btn;
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
        return v;
    }
}