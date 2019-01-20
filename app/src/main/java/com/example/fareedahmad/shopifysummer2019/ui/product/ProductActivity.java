package com.example.fareedahmad.shopifysummer2019.ui.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.example.fareedahmad.shopifysummer2019.R;
import com.example.fareedahmad.shopifysummer2019.model.Collection;
import com.example.fareedahmad.shopifysummer2019.model.Product;
import com.example.fareedahmad.shopifysummer2019.network.NetworkManager;

import java.util.List;

public class ProductActivity extends AppCompatActivity implements ProductContract.View {

    public static final String COLLECTION_TITLE_EXTRA = "collection_title";
    public static final String COLLECTION_IMAGE_EXTRA = "collection_img";
    public static final String COLLECTION_ID_EXTRA = "collection_id";

    private String collectionTitle;
    private String collectionImg;
    private long collectionId;


    private RecyclerView recyclerView;

    private ProductContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        setTitle("Products");
        collectionTitle = getIntent().getStringExtra(COLLECTION_TITLE_EXTRA);
        collectionImg = getIntent().getStringExtra(COLLECTION_IMAGE_EXTRA);
        collectionId= getIntent().getLongExtra(COLLECTION_ID_EXTRA,0);

        recyclerView = findViewById(R.id.productRecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        presenter = new ProductPresenterImpl(this, new NetworkManager());
        presenter.getProducts(collectionId);
    }

    @Override
    public void displayProdcuts(List<Product> productList) {
        recyclerView.setAdapter(new ProductAdapter(productList,collectionTitle,collectionImg));
    }
}
