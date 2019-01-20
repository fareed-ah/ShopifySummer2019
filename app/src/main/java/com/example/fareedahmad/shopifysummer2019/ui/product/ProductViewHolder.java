package com.example.fareedahmad.shopifysummer2019.ui.product;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.fareedahmad.shopifysummer2019.R;
import com.example.fareedahmad.shopifysummer2019.databinding.ItemProductBinding;
import com.example.fareedahmad.shopifysummer2019.model.Product;
import com.squareup.picasso.Picasso;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    private ItemProductBinding binding;

    public ProductViewHolder(@NonNull ItemProductBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(Product product,String collectionTitle, String collectionImage){
        Picasso.get().load(collectionImage).into((ImageView) binding.getRoot().findViewById(R.id.collectionImage));

        binding.setCollectionImg(collectionImage);
        binding.setCollectionTitle(collectionTitle);
        binding.setProduct(product);
        binding.executePendingBindings();
    }
}
