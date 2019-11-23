package com.example.warrrapp.model;

import com.example.warrrapp.R;

import java.util.ArrayList;
import java.util.List;

public class Guns {
    public List<Item> getGuns(){
        List<Item> gunsList = new ArrayList<>();
        gunsList.add(new Item("Gun 1", R.drawable.gun1,"Model 1",2));
        gunsList.add(new Item("Gun 2", R.drawable.gun2,"Model 2",3));
        gunsList.add(new Item("Gun 3", R.drawable.gun3,"Model 3",4));
        gunsList.add(new Item("Gun 4", R.drawable.gun4,"Model 4",5));
        gunsList.add(new Item("Gun 5", R.drawable.gun5,"Model 5",3));
        return gunsList;
    }
}
