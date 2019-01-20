package com.example.fareedahmad.shopifysummer2019.ui.product;

import com.example.fareedahmad.shopifysummer2019.model.Product;

import java.util.List;

public interface ProductContract {
    interface View{
       void displayProdcuts(List<Product> productList);
    }
    interface Presenter{
        void getProducts(long collectionId);
    }
}
