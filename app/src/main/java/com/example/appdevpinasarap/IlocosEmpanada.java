package com.example.appdevpinasarap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class    IlocosEmpanada extends AppCompatActivity {

    TextView txtempanada,titleempanada;
    ImageButton backbtn_longempanada;
    FloatingActionButton bookmark_empanada;
    ImageView imageEmpanada;

    FirebaseUser user;
    DatabaseReference reference,reference1, db, db1;
    public String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilocos_empanada);

        bookmark_empanada = (FloatingActionButton) findViewById(R.id.bookmark_empanada);
        txtempanada = (TextView) findViewById(R.id.txtempanada);
        backbtn_longempanada = (ImageButton) findViewById(R.id.backbtn_longempanada);
        imageEmpanada = (ImageView) findViewById(R.id.imageEmpanada);

        backbtn_longempanada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IlocosEmpanada.this, RegionI.class));
            }
        });

        reference = FirebaseDatabase.getInstance().getReference();
        reference1 = reference.child("Bookmarks").child("Empanada");

        final TextView titleempanada = (TextView) findViewById(R.id.titleempanada);

        reference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String texts = snapshot.child("image").getValue(String.class);
                String link = snapshot.child("image").getValue(String.class);
                String titles = snapshot.child("name").getValue(String.class);


                titleempanada.setText(titles);
                Picasso.get().load(link).into(imageEmpanada);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        bookmark_empanada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title1 = titleempanada.getText().toString();


                if (!title1.isEmpty()) {
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    db = FirebaseDatabase.getInstance().getReference();
                    db1 = db.child("profdata");


                    db1.child(user.getUid()).child("Bookmarks").child("Empanada").child("name").setValue(title1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(IlocosEmpanada.this, "Bookmarked Successfully", Toast.LENGTH_SHORT).show();
                        }
                    });
                    //titlepigar.setText(getIntent().getExtras().getString("title"));
                }
            }
        });

        setHtmlTextView("<b>Prep Time</b>\n" +
                "<br>    45 mins\n</br>" +
                "<br>     Cooking Time\n</br>" +
                "<br>     6 mins\n</br>" +
                "<br>     Total Time\n</br>" +
                "<br>     51 mins\n</br>" +
                "<br>\n</br>" +
                "<br> <b>Ingredients:</b>\n</br>" +
                "<br>   <b>For the Dough:</b>\n</br>" +
                "<br>        2 cups chicken broth or 2 cups water + 1 teaspoon salt\n</br>" +
                "<br>        1 cup rice flour plus 1 – 2 cups more for kneading\n</br>" +
                "<br>        1 – 2 teaspoons annatto powder achuete \n</br>" +
                "<br>   <b>For the Filling:</b>\n</br>" +
                "<br>        Grated green papaya or finely shredded green cabbage small\n</br>" +
                "<br>        1 cup cooked yellow split mung beans or regular mung beans\n</br>" +
                "<br>        Longganisa remove casing and saute in pan until cooked through\n</br>" +
                "<br>        ¼ cup canola oil for dipping dough\n</br>" +
                "<br>        Oil for frying\n</br>" +
                "<br>   <b>Dipping Sauce:</b>\n</br>" +
                "<br>        1 cup vinegar I used Sukang Iloko\n</br>" +
                "<br>        1 teaspoon salt\n</br>" +
                "<br>        ½ teaspoon ground black pepper\n</br>" +
                "<br>        ½ teaspoon chilli flakes or chopped fresh chilies\n</br>" +
                "<br>        2 cloves of garlic finely chopped\n</br>" +
                "<br>   <b>Ingredients:</b>\n</br>" +
                "<br>        Small rolling pin\n</br>" +
                "<br>        1 large ziploc bag all sides slit open (or 2 sheets of clean plastic)\n</br>" +
                "<br>        Plate for shaping empanada\n</br>" +
                "<br>\n</br>" +
                "<br> <b>How to Cook:</b>\n</br>" +
                "<br>     1. Put 1 cup of rice flour in a big bowl. Set aside while you prepare the dough.\n</br>" +
                "<br>     2. In a pan (I used nonstick), pour chicken broth (or water with salt) and add annatto powder. Stir well. Bring to a full boil and add 1 cup rice flour at once then stir using a wooden spoon. Lower the heat (low) and continue stirring for 3-5 minutes or until the liquid is fully absorbed.\n</br>" +
                "<br>     3. Transfer the cooked dough to the prepared bowl with the rice flour. While still hot, knead by using a spatula to incorporate the dry flour to the cooked dough. Switch to using your hands when it’s cool enough to handle. Keep kneading until all the rice flour is absorbed and the dough will be a little stiff and not stretchy. You may need to add more flour (1 – 1 ½ cups more) as rice flour absorbs moisture differently depending on the brand***. Rest the dough while you prepare the rest of the ingredients.\n</br>" +
                "<br>     4. Prepare the papaya or cabbage in a large bowl. Add the cooked mung beans and season with ground black pepper. Set aside. Place the cooked longganisa in another bowl. Start heating about 1 ½. – 2 inches of oil (for frying) in a deep frying pan.\n</br>" +
                "<br>     5. Grab a golf ball sized dough, dip generously in oil and place between sheets of the ziploc bag. Roll thinly to make a big circle. Place about ⅓ – ½ cup of the prepared vegetables and top with longganisa in the middle. Create an opening and crack the egg. Carefully close the empanada by lifting one end (to create a semicircle) and press the edges to seal. Use a plate to trim the dough by rolling from one end to the other.\n</br>" +
                "<br>     6. Fry until both sides are crisp and golden. Drain in a colander seam side down to let the excess oil drip. Serve while hot with the vinegar dipping sauce.\n</br>" +
                "<br> \n</br>" +
                "<br> <i><b>Originated</b>\n</br>" +
                "<br>     Luzon\n</br>" +
                "<br>     Region I, Ilocos Sur</i></br>");

    }
    public void setHtmlTextView(String html) {
        if (Build.VERSION.SDK_INT >= 24) {
            txtempanada.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
        } else {
            txtempanada.setText(Html.fromHtml(html));
        }

    }
}