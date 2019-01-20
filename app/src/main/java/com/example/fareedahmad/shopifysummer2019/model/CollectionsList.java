package com.example.fareedahmad.shopifysummer2019.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionsList {

    @SerializedName("custom_collections")
    private List<Collection> custom_collections;

    public CollectionsList(List<Collection> custom_collections) {
        this.custom_collections = custom_collections;
    }

    public List<Collection> getCustom_collections() {
        return custom_collections;
    }

    public void setCustom_collections(List<Collection> custom_collections) {
        this.custom_collections = custom_collections;
    }
}
