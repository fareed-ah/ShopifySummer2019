package com.example.fareedahmad.shopifysummer2019.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectsList {

    @SerializedName("collects")
    private List<Collect> collects;

    public CollectsList(List<Collect> collects) {
        this.collects = collects;
    }

    public List<Collect> getCollects() {
        return collects;
    }

    public void setCollects(List<Collect> collects) {
        this.collects = collects;
    }
}
