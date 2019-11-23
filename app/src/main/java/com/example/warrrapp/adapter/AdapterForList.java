package com.example.warrrapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.warrrapp.R;
import com.example.warrrapp.model.Item;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;



public class AdapterForList extends ArrayAdapter {
     private List<Item> list;
    private Activity context;

    public AdapterForList(@NonNull Activity context, int resource, List<Item> list) {
        super(context, resource, list);
        this.list =list;
        this.context= context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

       View row =convertView;

        LayoutInflater layoutInflater = context.getLayoutInflater();
        if(convertView==null)
            row = layoutInflater.inflate(R.layout.list_item, null, true);

        ImageView imageView = (ImageView) row.findViewById(R.id.image_view);
        TextView desc = row.findViewById(R.id.description);
        TextView title = row.findViewById(R.id.title);
        imageView.setImageResource(list.get(position).getImage());
        desc.setText(list.get(position).getDescription());
        title.setText(list.get(position).getName());
        RatingBar ratingBar = row.findViewById(R.id.ratingBar);
        ratingBar.setRating(list.get(0).getRating());

        return row;
    }
}
