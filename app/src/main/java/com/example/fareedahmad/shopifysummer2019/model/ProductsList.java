package com.example.fareedahmad.shopifysummer2019.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsList {

    @SerializedName("products")
    private List<Product> productList;

    public ProductsList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
