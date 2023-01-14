package com.example.appdevpinasarap;

import android.media.Image;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ViewHolderClass extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView;

    public ViewHolderClass(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        nameView = (TextView) itemView.findViewById(R.id.nameView);

    }
}
