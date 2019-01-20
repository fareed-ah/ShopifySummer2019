package com.example.fareedahmad.shopifysummer2019.network;

import com.example.fareedahmad.shopifysummer2019.model.CollectionsList;
import com.example.fareedahmad.shopifysummer2019.model.CollectsList;
import com.example.fareedahmad.shopifysummer2019.model.ProductsList;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShopifyApiService {
    @GET("admin/custom_collections.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Single<CollectionsList> getCollections();

    @GET("admin/collects.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6&")
    Single<CollectsList> getCollects(@Query("collection_id") long collectionId);

    @GET("admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6&")
    Single<ProductsList> getProducts(@Query("ids")String productIds);
}
