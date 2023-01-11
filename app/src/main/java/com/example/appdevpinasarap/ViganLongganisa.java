package com.example.appdevpinasarap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViganLongganisa extends AppCompatActivity {

    FloatingActionButton bookmark_vigan;
    TextView txtlongganisa;
    ImageButton backbtn_long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigan_longganisa);

        String name = getIntent().getStringExtra("NAME");
        int image = getIntent().getIntExtra("IMAGE",0);

        txtlongganisa = (TextView) findViewById(R.id.textpigar);
        backbtn_long = (ImageButton) findViewById(R.id.backbtn_long);
        bookmark_vigan = (FloatingActionButton) findViewById(R.id.bookmark_iloko);

        backbtn_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViganLongganisa.this,RegionI.class));
            }
        });


        setHtmlTextView(txtlongganisa,"<b>Prep Time</b>\n" +
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
    public void setHtmlTextView(TextView txtlongganisa, String html) {
        if (Build.VERSION.SDK_INT >= 24) {
            txtlongganisa.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
        } else {
            txtlongganisa.setText(Html.fromHtml(html));
        }
    }
}