package com.example.kittycam_final;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {



    TextView name, date, time;
    ImageView image;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textView12);
        date = itemView.findViewById(R.id.textView13);
        time = itemView.findViewById(R.id.textView14);
        image = itemView.findViewById(R.id.imageView);




    }
}
