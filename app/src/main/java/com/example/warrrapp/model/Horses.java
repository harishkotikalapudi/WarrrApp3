package com.example.warrrapp.model;

import com.example.warrrapp.R;

import java.util.ArrayList;
import java.util.List;

public class Horses {

    public List<Item> getHorses(){
      List<Item> horseList = new ArrayList<>();
      horseList.add(new Item("Horse 1", R.drawable.horse1,"Breed 1",1f));
      horseList.add(new Item("Horse 2", R.drawable.horse2,"Breed 2",5f));
      horseList.add(new Item("Horse 3", R.drawable.horse3,"Breed 3",3f));
      horseList.add(new Item("Horse 4", R.drawable.horse4,"Breed 4",2f));
      horseList.add(new Item("Horse 5", R.drawable.horse5,"Breed 5",4f));
      return horseList;
  }
}
