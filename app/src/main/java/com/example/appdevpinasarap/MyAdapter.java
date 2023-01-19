package com.example.appdevpinasarap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolderClass> {

    Context context;
    List<Bookmarks> items;

    public MyAdapter(Context context, List<Bookmarks> items) {
        this.context = context;
        this.items = items;

    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        ViewHolderClass holder = new ViewHolderClass(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolderClass holder, int position) {
        Bookmarks itemsd = items.get(position);
        holder.nameView.setText(items.get(position).getName());
        holder.imageView.setImageResource(items.get(position).getImage());
        String nameView_position = items.get(position).getName();
        holder.nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ViganLongganisa.class);
                view.getContext().startActivity(intent);
            }
        });


        //Bookmarking or Favorites System

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nameView;
        CardView layout;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            layout = (CardView) itemView.findViewById(R.id.cardview_layout);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            nameView = (TextView) itemView.findViewById(R.id.nameView);
        }
    }
}
