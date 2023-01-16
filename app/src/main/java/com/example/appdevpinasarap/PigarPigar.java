package com.example.appdevpinasarap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class PigarPigar extends AppCompatActivity {

    FloatingActionButton bookmark_pigar;
    TextView textpigar, titlepigar;
    ImageButton backbtn_longpigar;
    ImageView imagePigar;

    FirebaseUser user;
    DatabaseReference reference,reference1, db, db1;
    public String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pigar_pigar);

        textpigar = (TextView) findViewById(R.id.textpigar);
        backbtn_longpigar = (ImageButton) findViewById(R.id.backbtn_longpigar);
        bookmark_pigar = (FloatingActionButton) findViewById(R.id.bookmark_pigar);
        imagePigar = (ImageView) findViewById(R.id.imagePigar);

        backbtn_longpigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PigarPigar.this,Pangasinan.class));
            }
        });

        reference = FirebaseDatabase.getInstance().getReference();
        reference1 = reference.child("Bookmarks").child("PigarPigar");

        final TextView titlepigar = (TextView) findViewById(R.id.titlepigar);
        final TextView textlongganisa = (TextView) findViewById(R.id.textpigar);

        reference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String texts = snapshot.child("image").getValue(String.class);
                String link = snapshot.child("image").getValue(String.class);
                String titles = snapshot.child("name").getValue(String.class);


                titlepigar.setText(titles);
                Picasso.get().load(link).into(imagePigar);

            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        bookmark_pigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title1 = titlepigar.getText().toString();


                if (!title1.isEmpty()) {
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    db = FirebaseDatabase.getInstance().getReference();
                    db1 = db.child("profdata");


                    db1.child(user.getUid()).child("Bookmarks").child("PigarPigar").child("name").setValue(title1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(PigarPigar.this, "Bookmarked Successfully", Toast.LENGTH_SHORT).show();
                        }
                    });
                    //titlepigar.setText(getIntent().getExtras().getString("title"));
                }
            }
        });


        setHtmlTextView(textpigar,"<b>Prep Time</b>\n" +
                "<br>    1 hour 15 mins\n</br>" +
                "<br>     Cooking Time\n</br>" +
                "<br>     20 mins\n</br>" +
                "<br>     Total Time\n</br>" +
                "<br>     1 hour 35 mins \n</br>" +
                "<br>\n</br>" +
                "<br> <b>Ingredients:</b>\n</br>" +
                "<br>      500g beef, sliced thinly\n</br>" +
                "<br>      150g beef liver, sliced thinly\n</br>" +
                "<br>      1 large onions, sliced \n</br>" +
                "<br>      4 tbsp soy sauce\n</br>" +
                "<br>      1 tsp salt\n</br>" +
                "<br>      1 tsp black pepper\n</br>" +
                "<br>      Oil\n</br>" +
                "<br> \n</br>" +
                "<br> <b>How to Cook</b>\n</br>" +
                "<br>      1. In a bowl, marinate beef slices and liver for at least an hour in soy sauce, salt and black pepper.\n</br>" +
                "<br>      2. Now using a wok, add lots of oil enough for deep-frying the beef. Heat up the oil until it is near its smoking point, then add the beef slices and liver slices.\n</br>" +
                "<br>      3. Once the sides of each beef slices are crispy (the sides will burn first) remove beef by using a slotted spoon and place it on a metal sieve (to allow dripping of oil) then quickly add the sliced onions and mix, using the remaining heat to cook the onions.\n</br>" +
                "<br> \n</br>" +
                "<br> <i><b>Originated</b>\n</br>" +
                "<br>     Luzon\n</br>" +
                "<br>     Region I, Pangasinan</i></br>");
    }


    public void setHtmlTextView(TextView textpigar, String html) {
        if (Build.VERSION.SDK_INT >= 24) {
            textpigar.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
        } else {
            textpigar.setText(Html.fromHtml(html));
        }




    }
}
