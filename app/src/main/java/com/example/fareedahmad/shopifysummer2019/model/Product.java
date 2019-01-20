package com.example.fareedahmad.shopifysummer2019.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("variants")
    private List<Variant> variants;

    public Product(long id, String title, List<Variant> variants) {
        this.id = id;
        this.title = title;
        this.variants = variants;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity(){
        int value = 0;
        for (Variant variant:variants) {
            value += variant.getQuantity();
        }
        return value;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }
}
