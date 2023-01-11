package com.example.appdevpinasarap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PigarPigar extends AppCompatActivity {

    TextView txtpigarpigar;
    ImageButton backbtn_long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pigar_pigar);

        txtpigarpigar = (TextView) findViewById(R.id.txtpigarpigar);
        backbtn_long = (ImageButton) findViewById(R.id.backbtn_long);

        backbtn_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PigarPigar.this,RegionI.class));
            }
        });


        setHtmlTextView(txtpigarpigar,"<b>Prep Time</b>\n" +
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
    public void setHtmlTextView(TextView txtpigarpigar, String html) {
        if (Build.VERSION.SDK_INT >= 24) {
            txtpigarpigar.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
        } else {
            txtpigarpigar.setText(Html.fromHtml(html));
        }




    }
}
