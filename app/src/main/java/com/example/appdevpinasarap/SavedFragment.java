package com.example.appdevpinasarap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class SavedFragment extends Fragment {

RecyclerView bookmark_view;
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
        myAdapter adapterMy = new myAdapter(getContext(), items);
        bookmark_view.setAdapter(adapterMy);


        return v;
    }
}