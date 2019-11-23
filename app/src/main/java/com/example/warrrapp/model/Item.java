package com.example.warrrapp.model;

public class Item  {

    private String name;
    private int image;
    private String description;
    private float rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Item(String name, int image, String description, float rating) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.rating = rating;
    }
}
