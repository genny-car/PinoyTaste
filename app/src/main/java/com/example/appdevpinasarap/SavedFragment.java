package com.example.appdevpinasarap;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class SavedFragment extends Fragment{

    RecyclerView bookmark_view;

    Context context;
    FirebaseUser user;
    FirebaseDatabase db;
    FirebaseAuth iAuth;
    DatabaseReference reference,reference1;

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


        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference();
        reference1 = reference.child("profdata").child(user.getUid()).child("Bookmarks");



        //items.add(new Bookmarks(txtviewtest.getText().toString(), R.drawable.viganlongganisa));//
        //items.add(new Bookmarks("Pigar Pigar", R.drawable.pigarpigar));//



        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Bookmarks> items = new ArrayList<Bookmarks>();

//                String titles = snapshot.child("name").getValue(String.class);
//
//                items.add(new Bookmarks(titles, R.drawable.viganlongganisa));
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    String titles = postSnapshot.child("name").getValue(String.class);
                    Object link = postSnapshot.child("name").getKey();

                    Log.d("SavedFragment", "test");

                    /*Drawable imageLink = getResources().getDrawable(R.drawable.viganlongganisa, context.getTheme());
                    if (titles == "Iloko Halo-halo") {
                        imageLink = R.drawable.viganlongganisa;
                    }*/
                    items.add(new Bookmarks(titles, 0));
                }



                bookmark_view = v.findViewById(R.id.bookmark_view);
                bookmark_view.setLayoutManager(new LinearLayoutManager(getContext()));
                bookmark_view.setHasFixedSize(true);
                MyAdapter adapterMy = new MyAdapter(context, items);
                bookmark_view.setAdapter(adapterMy);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        return v;
    }
}