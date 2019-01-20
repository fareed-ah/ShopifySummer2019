package com.example.fareedahmad.shopifysummer2019.ui.collection;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.fareedahmad.shopifysummer2019.databinding.ItemCollectionBinding;
import com.example.fareedahmad.shopifysummer2019.model.Collection;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionViewHolder> {

    private List<Collection> collectionList;
    private CollectionContract.Presenter presenter;

    public CollectionAdapter(List<Collection> collectionList, CollectionContract.Presenter presenter) {
        this.collectionList = collectionList;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public CollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ItemCollectionBinding binding = ItemCollectionBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CollectionViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull CollectionViewHolder holder, int position) {
        holder.onBind(collectionList.get(position),presenter);
    }

    @Override
    public int getItemCount() {
        return collectionList.size();
    }
}
