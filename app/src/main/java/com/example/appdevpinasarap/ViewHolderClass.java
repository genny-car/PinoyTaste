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
    ImageButton imageButtonView;

    public ViewHolderClass(@NonNull View itemView, SelectInterface listener) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        nameView = (TextView) itemView.findViewById(R.id.nameView);
        imageButtonView = (ImageButton) itemView.findViewById(R.id.imageButtonView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    int pos = getBindingAdapterPosition();

                    if(pos != RecyclerView.NO_POSITION){
                        listener.onItemClicked(pos);
                    }
                }
            }
        });
    }
}
