package com.example.warrrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.warrrapp.model.Item;

import java.util.ArrayList;
import java.util.List;

public class DisplaySelectedData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_selected_data);
        String name = getIntent().getExtras().getString("contact");
        String data1 = getIntent().getExtras().getString("data1");
        String data2 = getIntent().getExtras().getString("data2");
        TextView contact = findViewById(R.id.contact);
        contact.setText(name);
        TextView horse = findViewById(R.id.gun);
        horse.setText(data2);
        TextView gun = findViewById(R.id.horse);
        gun.setText(data1);

    }
}
