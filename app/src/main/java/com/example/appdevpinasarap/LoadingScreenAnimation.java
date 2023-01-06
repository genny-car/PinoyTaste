package com.example.appdevpinasarap;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingScreenAnimation extends Animation {

    private Context context;
    private ProgressBar progressBar;
    private TextView loadingtxt;
    private float to;
    private float from;

    public LoadingScreenAnimation(Context context, ProgressBar progressBar, TextView loadingtxt, float from, float to){
        this.context = context;
        this.progressBar = progressBar;
        this.loadingtxt = loadingtxt;
        this.from = from;
        this.to = to;

    }

    @Override
    protected void  applyTransformation(float interpolatedTime, Transformation t){
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int)value);
        loadingtxt.setText((int)value+" %");

            if (value == to){
                context.startActivity(new Intent(context, AfterSplashScreen.class));
            }
    }
}
