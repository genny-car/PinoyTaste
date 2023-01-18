package com.example.appdevpinasarap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class IlokoHaloHalo extends AppCompatActivity {


    TextView txtilokohalohalo,titleiloko;
    ImageButton backbtn_longiloko;
    FloatingActionButton bookmark_iloko;
    ImageView imageIloko;

    FirebaseUser user;
    DatabaseReference reference,reference1, db, db1;
    public String userID;

    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iloko_halo_halo);

        txtilokohalohalo = (TextView) findViewById(R.id.txtilokohalohalo);
        backbtn_longiloko = (ImageButton) findViewById(R.id.backbtn_longiloko);
        imageIloko = (ImageView) findViewById(R.id.imageIloko);
        bookmark_iloko = (FloatingActionButton) findViewById(R.id.bookmark_iloko);

        backbtn_longiloko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IlokoHaloHalo.this,RegionI.class));
            }
        });

        reference = FirebaseDatabase.getInstance().getReference();
        reference1 = reference.child("Bookmarks").child("IlokoHaloHalo");

        final TextView titleiloko= (TextView) findViewById(R.id.titleiloko);

        reference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String texts = snapshot.child("image").getValue(String.class);
                String link = snapshot.child("image").getValue(String.class);
                String titles = snapshot.child("name").getValue(String.class);


                titleiloko.setText(titles);
                Picasso.get().load(link).into(imageIloko);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        bookmark_iloko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;

                String title1 = titleiloko.getText().toString();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i==1){
                            if (!title1.isEmpty()) {
                                user = FirebaseAuth.getInstance().getCurrentUser();
                                db = FirebaseDatabase.getInstance().getReference();
                                db1 = db.child("profdata");


                                db1.child(user.getUid()).child("Bookmarks").child("IlokoHaloHalo").child("name").setValue(title1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(IlokoHaloHalo.this, "Bookmarked Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    /*titlelongganisa.setText(getIntent().getExtras().getString("title"));
                    int imageId = getIntent().getIntExtra("image",0);
                    imageLongganisa.setImageResource(imageId);*/

                            }
                        }else if(i==2){
                            db1.child(user.getUid()).child("Bookmarks").child("IlokoHaloHalo").child("name").setValue(null).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(IlokoHaloHalo.this, "Bookmark Removed", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        i = 0;

                    }
                }, 500);
            }
        });

        setHtmlTextView(txtilokohalohalo,"<b>Prep Time</b>\n" +
                "<br>    10 mins\n</br>" +
                "<br>     Cooking Time\n</br>" +
                "<br>     10 mins\n</br>" +
                "<br>     Total Time\n</br>" +
                "<br>     20 mins\n</br>" +
                "<br>\n</br>" +
                "<br> <b>Ingredients:</b>\n</br>" +
                "<br>      2 cups of shaved ice\n</br>" +
                "<br>      1 ripe large banana\n</br>" +
                "<br>      1 cup young shredded coconut, fresh or bottled\n</br>" +
                "<br>      1/2 cup sweet corn or chickpeas (garbanzos)\n</br>" +
                "<br>      2 cups evaporated milk\n</br>" +
                "<br>      1 cup firm gelatin set into a gel and cut into 1/2 inch cubes\n</br>" +
                "<br>      2 ripe mangoes\n</br>" +
                "<br>      1 cup ripe jackfruit\n\n</br>" +
                "<br>      1 cup cooked sweet yams or (ube halaya)\n</br>" +
                "<br>      4 scoops of favorite ice cream\n</br>" +
                "<br>      1/2 cup rice pop\n</br>" +
                "<br> \n</br>" +
                "<br> <b>How to Cook</b>\n</br>" +
                "<br>      1. Peel mangoes and slice into half-inch cubes.\n</br>" +
                "<br>      2. Divide each ingredient into 4 equal parts. Get 4 tall glasses, then place each ingredients layer by layer.\n</br>" +
                "<br>      3. Put the one-half cup of shaved ice to each glass.\n</br>" +
                "<br>      4. Pour a quarter of milk evap over shaved ice to each glass.\n</br>" +
                "<br>      5. Put a scoop of ice cream on top\n</br>" +
                "<br>      6. Drizzle some nuts or rice crispies on top of the ice cream.\n</br>" +
                "<br> \n</br>" +
                "<br> <i><b>Originated</b>\n</br>" +
                "<br>     Luzon\n</br>" +
                "<br>     Region I, Ilocos La Union</i></br>");
    }
    public void setHtmlTextView(TextView txtilokohalohalo, String html) {
        if (Build.VERSION.SDK_INT >= 24) {
            txtilokohalohalo.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
        } else {
            txtilokohalohalo.setText(Html.fromHtml(html));
        }


    }
}