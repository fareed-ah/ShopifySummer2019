package com.example.fareedahmad.shopifysummer2019.ui.collection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.fareedahmad.shopifysummer2019.R;
import com.example.fareedahmad.shopifysummer2019.model.Collection;
import com.example.fareedahmad.shopifysummer2019.network.NetworkManager;
import com.example.fareedahmad.shopifysummer2019.ui.product.ProductActivity;

import java.util.List;

public class CollectionsActivity extends AppCompatActivity implements CollectionContract.View {

    private CollectionContract.Presenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Collections");
        setContentView(R.layout.activity_collections);
        presenter = new CollectionPresenterImpl(new NetworkManager(),this);
        recyclerView = findViewById(R.id.collectionRecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        presenter.getCollections();
    }

    @Override
    public void displayCollections(List<Collection> collectionsList) {
        recyclerView.setAdapter(new CollectionAdapter(collectionsList,presenter));
    }

    @Override
    public void navigateToProductsScreen(Collection collection) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra(ProductActivity.COLLECTION_TITLE_EXTRA, collection.getTitle());
        intent.putExtra(ProductActivity.COLLECTION_IMAGE_EXTRA, collection.getImage().getSrc());
        intent.putExtra(ProductActivity.COLLECTION_ID_EXTRA, collection.getId());
        startActivity(intent);
        Log.d("Starting new actitivity", "navigateToProductsScreen: ");
    }

}
