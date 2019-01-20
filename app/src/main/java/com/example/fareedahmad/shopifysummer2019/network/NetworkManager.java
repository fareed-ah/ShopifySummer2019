package com.example.fareedahmad.shopifysummer2019.network;

import com.example.fareedahmad.shopifysummer2019.model.CollectionsList;
import com.example.fareedahmad.shopifysummer2019.model.CollectsList;
import com.example.fareedahmad.shopifysummer2019.model.ProductsList;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;
import java.util.Map;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private ShopifyApiService shopifyApiService = new Retrofit.Builder()
            .baseUrl("https://shopicruit.myshopify.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(new OkHttpClient())
            .build()
            .create(ShopifyApiService.class);

    public Single<CollectionsList> getCollections(){return shopifyApiService.getCollections();}
    public Single<CollectsList> getCollects(long collectionId){return shopifyApiService.getCollects(collectionId);}
    public Single<ProductsList> getProducts(String productIds) {return shopifyApiService.getProducts(productIds);}
}
