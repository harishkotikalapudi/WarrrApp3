package com.example.warrrapp.model;

import com.example.warrrapp.R;

import java.util.ArrayList;
import java.util.List;

public class Ammunition {
    public List<Item> getAmmunition(){
        List<Item> ammunitionList = new ArrayList<>();
        ammunitionList.add(new Item("Ammo 1", R.drawable.gun1,"Model Ammo 1",2));
        ammunitionList.add(new Item("Ammo 2", R.drawable.gun2,"Model Ammo 2",3));
        ammunitionList.add(new Item("Ammo 3", R.drawable.gun3,"Model Ammo 3",4));
        ammunitionList.add(new Item("Ammo 4", R.drawable.gun4,"Model Ammo 4",5));
        ammunitionList.add(new Item("Ammo 5", R.drawable.gun5,"Model Ammo 5",3));
        return ammunitionList;
    }
}
