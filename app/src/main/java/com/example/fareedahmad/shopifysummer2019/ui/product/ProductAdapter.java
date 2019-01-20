package com.example.fareedahmad.shopifysummer2019.ui.product;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.fareedahmad.shopifysummer2019.databinding.ItemProductBinding;
import com.example.fareedahmad.shopifysummer2019.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<Product> productList;
    private String collectionTitle;
    private String collectionImage;

    public ProductAdapter(List<Product> productList, String collectionTitle, String collectionImage) {
        this.productList = productList;
        this.collectionTitle = collectionTitle;
        this.collectionImage = collectionImage;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        ItemProductBinding binding = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        productViewHolder.onBind(productList.get(i), collectionTitle,collectionImage);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
