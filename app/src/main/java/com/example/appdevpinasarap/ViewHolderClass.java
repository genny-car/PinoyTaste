package com.example.appdevpinasarap;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderClass extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView;

    public ViewHolderClass(@NonNull View itemView) {
        super(itemView);

        imageView =itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.nameView);
    }
}
