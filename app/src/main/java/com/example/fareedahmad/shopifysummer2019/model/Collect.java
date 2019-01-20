package com.example.fareedahmad.shopifysummer2019.model;

import com.google.gson.annotations.SerializedName;

public class Collect {

    @SerializedName("product_id")
    private long productID;

    public Collect(long productID) {
        this.productID = productID;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }
}
