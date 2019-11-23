package com.example.warrrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.warrrapp.adapter.AdapterForList;
import com.example.warrrapp.model.Ammunition;
import com.example.warrrapp.model.Guns;
import com.example.warrrapp.model.Horses;

public class DisplayList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        ListView listView = findViewById(R.id.listView);
       final int type = getIntent().getExtras().getInt(Types.TYPE);
        setListData(type,listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent();
                intent.putExtra("position",i);
                setResult(type,intent);
                finish();
            }
        });

    }

    private void setListData(int type,ListView listView) {
        if (type==Types.HORSE){
            listView.setAdapter(new AdapterForList(this,R.layout.list_item, new Horses().getHorses()));

        }else if(type==Types.GUN){
            listView.setAdapter(new AdapterForList(this,R.layout.list_item, new Guns().getGuns()));
        }else if (type==Types.AMMUNITION){
            listView.setAdapter(new AdapterForList(this,R.layout.list_item, new Ammunition().getAmmunition()));
        }
    }
}
