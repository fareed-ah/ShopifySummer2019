package com.example.fareedahmad.shopifysummer2019.ui.collection;

import com.example.fareedahmad.shopifysummer2019.model.Collection;

import java.util.List;

public interface CollectionContract {

    interface View {
        void displayCollections(List<Collection> collectionsList);
        void navigateToProductsScreen(Collection collection);
    }

    interface Presenter {
        void getCollections();
        void onCollectionClicked(Collection collection);
    }
}
