package com.example.appdevpinasarap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class SavedFragment extends Fragment{

    RecyclerView bookmark_view;

    Context context;
    FirebaseUser user;
    FirebaseDatabase db;
    FirebaseAuth iAuth;
    DatabaseReference reference;

    ArrayList<Item> items;
    public SavedFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_saved, container, false);
        bookmark_view = v.findViewById(R.id.bookmark_view);


        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Vigan Longganisa", R.drawable.viganlongganisa));
        items.add(new Item("Pigar Pigar", R.drawable.pigarpigar));

        bookmark_view = v.findViewById(R.id.bookmark_view);
        bookmark_view.setLayoutManager(new LinearLayoutManager(getContext()));
        bookmark_view.setHasFixedSize(true);
        MyAdapter adapterMy = new MyAdapter(context, items);
        bookmark_view.setAdapter(adapterMy);


        return v;
    }
}