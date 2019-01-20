package com.example.fareedahmad.shopifysummer2019.ui.product;

import android.util.Log;

import com.example.fareedahmad.shopifysummer2019.model.Collect;
import com.example.fareedahmad.shopifysummer2019.model.CollectsList;
import com.example.fareedahmad.shopifysummer2019.model.Product;
import com.example.fareedahmad.shopifysummer2019.model.ProductsList;
import com.example.fareedahmad.shopifysummer2019.network.NetworkManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductPresenterImpl  implements ProductContract.Presenter {

    private ProductContract.View view;
    private NetworkManager networkManager;

    public ProductPresenterImpl(ProductContract.View view, NetworkManager networkManager) {
        this.view = view;
        this.networkManager = networkManager;
    }

    @Override
    public void getProducts(final long collectionId) {
        networkManager.getCollects(collectionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<CollectsList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(CollectsList collectsList) {
                        String productIds = "";
                        for (Collect collect: collectsList.getCollects()) {
                            Log.d("Products IDS:", ""+collect.getProductID());
                            productIds += collect.getProductID() + ",";
                        }
                        productIds.substring(0,productIds.length()-1);
                        Log.d("Products IDS QUERY:", ""+productIds);
                        getProductData(productIds);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ERROR", "onError: " + e.getMessage());

                    }
                });
    }

    private void getProductData(String productIds){
        networkManager.getProducts(productIds)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ProductsList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ProductsList productsList) {
                        view.displayProdcuts(productsList.getProductList());
                        for (Product product : productsList.getProductList()) {
                            Log.d("Final Products List:", ""+product.getTitle());

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ERROR", "onError: " + e.getMessage());
                    }
                });
    }
}
