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

import kotlinx.coroutines.internal.InternalAnnotationsKt;


public class SavedFragment extends Fragment implements SelectInterface{

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

        bookmark_view = v.findViewById(R.id.bookmark_view);
        bookmark_view.setLayoutManager(new LinearLayoutManager(getContext()));
        bookmark_view.setHasFixedSize(true);
        myAdapter adapterMy = new myAdapter(getContext(),items,this);
        bookmark_view.setAdapter(adapterMy);


        return v;
    }

    @Override
    public void onItemClicked(int position) {
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_saved, null);
        Intent intent = new Intent();
        intent.setClass(view.getContext(),ViganLongganisa.class);
        view.getContext().startActivity(intent);

        intent.putExtra("NAME", items.get(position).getName());
        intent.putExtra("IMAGE", items.get(position).getImage());

        startActivity(intent);
    }
}