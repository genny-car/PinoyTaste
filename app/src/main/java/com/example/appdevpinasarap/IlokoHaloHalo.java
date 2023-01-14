package com.example.appdevpinasarap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class IlokoHaloHalo extends AppCompatActivity {


    TextView txtilokohalohalo,titleiloko;
    ImageButton backbtn_longiloko;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iloko_halo_halo);

        txtilokohalohalo = (TextView) findViewById(R.id.txtilokohalohalo);
        backbtn_longiloko = (ImageButton) findViewById(R.id.backbtn_longiloko);

        backbtn_longiloko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IlokoHaloHalo.this,RegionI.class));
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