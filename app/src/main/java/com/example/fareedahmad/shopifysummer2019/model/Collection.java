package com.example.fareedahmad.shopifysummer2019.model;

import com.google.gson.annotations.SerializedName;

public class Collection {

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private Image image;

    public Collection(String title, Image image,long id) {
        this.title = title;
        this.image = image;
        this.id = id;
    }

    public String getTitle() {
        return title.replace(" collection","");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
