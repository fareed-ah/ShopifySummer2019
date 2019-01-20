package com.example.fareedahmad.shopifysummer2019.ui.collection;

import android.util.Log;
import android.widget.Toast;

import com.example.fareedahmad.shopifysummer2019.model.Collection;
import com.example.fareedahmad.shopifysummer2019.model.CollectionsList;
import com.example.fareedahmad.shopifysummer2019.network.NetworkManager;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CollectionPresenterImpl implements CollectionContract.Presenter {

    private NetworkManager networkManager;
    private CollectionContract.View view;

    public CollectionPresenterImpl(NetworkManager networkManager, CollectionContract.View view) {
        this.networkManager = networkManager;
        this.view = view;
    }

    @Override
    public void getCollections() {
        networkManager.getCollections()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<CollectionsList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(CollectionsList collectionsList) {
                        for (Collection collection: collectionsList.getCustom_collections()) {
                            Log.d("COLLECTION: ", collection.getTitle());
                        }
                        view.displayCollections(collectionsList.getCustom_collections());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ERROR", "onError: " + e.getMessage());
                    }
                });
    }

    @Override
    public void onCollectionClicked(Collection collection) {
        view.navigateToProductsScreen(collection);
    }
}
