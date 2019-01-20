package com.example.fareedahmad.shopifysummer2019.model;

import com.google.gson.annotations.SerializedName;

public class Variant {

    @SerializedName("inventory_quantity")
    private int quantity;

    public Variant(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
