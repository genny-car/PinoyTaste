package com.example.appdevpinasarap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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

public class ViganLongganisa extends AppCompatActivity  {

    FloatingActionButton bookmark_vigan;
    ImageButton backbtn_long;
    ImageView imageLongganisa;

    FirebaseUser user;
    DatabaseReference reference,reference1, db, db1;
    public String userID;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigan_longganisa);

        String name = getIntent().getStringExtra("NAME");
        int image = getIntent().getIntExtra("IMAGE",0);


        backbtn_long = (ImageButton) findViewById(R.id.backbtn_long);
        bookmark_vigan = (FloatingActionButton) findViewById(R.id.bookmark_iloko);

        backbtn_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViganLongganisa.this,RegionI.class));
            }
        });


        reference = FirebaseDatabase.getInstance().getReference();
        reference1 = reference.child("Bookmarks").child("ViganLongganisa");

        imageLongganisa = (ImageView) findViewById(R.id.imageLongganisa);
        final TextView titlelongganisa = (TextView) findViewById(R.id.titlelongganisa);
        final TextView textlongganisa = (TextView) findViewById(R.id.textpigar);

        reference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            String texts = snapshot.child("image").getValue(String.class);
            String link = snapshot.child("image").getValue(String.class);
            String titles = snapshot.child("name").getValue(String.class);

            Picasso.get().load(link).into(imageLongganisa);
            titlelongganisa.setText(titles);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        bookmark_vigan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;

                String title1 = titlelongganisa.getText().toString();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i==1){
                            if (!title1.isEmpty()) {
                                user = FirebaseAuth.getInstance().getCurrentUser();
                                db = FirebaseDatabase.getInstance().getReference();
                                db1 = db.child("profdata");


                                db1.child(user.getUid()).child("Bookmarks").child("ViganLongganisa").child("name").setValue(title1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(ViganLongganisa.this, "Bookmarked Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    /*titlelongganisa.setText(getIntent().getExtras().getString("title"));
                    int imageId = getIntent().getIntExtra("image",0);
                    imageLongganisa.setImageResource(imageId);*/

                            }
                        }else if(i==2){
                            db1.child(user.getUid()).child("Bookmarks").child("ViganLongganisa").child("name").setValue(null).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(ViganLongganisa.this, "Bookmark Removed", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        i = 0;

                    }
                }, 500);



            }
        });


        setHtmlTextView(textlongganisa,"<b>Prep Time</b>\n" +
                "<br>    15 mins\n</br>" +
                "<br>     Cooking Time\n</br>" +
                "<br>     7 mins\n</br>" +
                "<br>     Total Time\n</br>" +
                "<br>     17 mins\n</br>" +
                "<br>\n</br>" +
                "<br> <b>Ingredients:</b>\n</br>" +
                "<br>     3/4 kilogram ground pork\n</br>" +
                "<br>     1/4 kilogram pork fat\n</br>" +
                "<br>     1/4 cup garlic, minced\n</br>" +
                "<br>     1 teaspoon ground black pepper\n</br>" +
                "<br>     1/4 cup soy sauce\n</br>" +
                "<br>     1 teaspoon annatto powder (atsuete)\n</br>" +
                "<br>     1/4 cup iloko vinegar (sukang iloko), or vinegar\n</br>" +
                "<br> \n</br>" +
                "<br> <b>How to Cook</b>\n</br>" +
                "<br>    ~ In a large bowl, mix ground pork, pork fat, garlic, pepper, soy sauce, atsuete powder, and vinegar until well blended.\n</br>" +
                "<br>    ~ Portion meat mixture using an ice cream scoop onto a sheet of wax paper, measuring 5'' x 5''-inches. Roll until it forms into a log. Repeat with remaining meat mixtures\n</br>" +
                "<br>    ~ Chill for at least 12 hours.\n</br>" +
                "<br> \n</br>" +
                "<br> <i><b>Originated</b>\n</br>" +
                "<br>     Luzon\n</br>" +
                "<br>     Region I, Ilocos Norte</i></br>");




        }
    public void setHtmlTextView(TextView textlongganisa, String html) {
        if (Build.VERSION.SDK_INT >= 24) {
            textlongganisa.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
        } else {
            textlongganisa.setText(Html.fromHtml(html));
        }
    }
}