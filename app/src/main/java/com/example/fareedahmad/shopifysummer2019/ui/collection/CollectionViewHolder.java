package com.example.fareedahmad.shopifysummer2019.ui.collection;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.example.fareedahmad.shopifysummer2019.databinding.ItemCollectionBinding;
import com.example.fareedahmad.shopifysummer2019.model.Collection;

public class CollectionViewHolder extends RecyclerView.ViewHolder {

    private ItemCollectionBinding binding;

    public CollectionViewHolder(@NonNull ItemCollectionBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(Collection collection, CollectionContract.Presenter presenter){
        binding.setCollection(collection);
        binding.setPresenter(presenter);
        binding.executePendingBindings();
    }
}
