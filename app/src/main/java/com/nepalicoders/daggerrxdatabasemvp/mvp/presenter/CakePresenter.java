package com.nepalicoders.daggerrxdatabasemvp.mvp.presenter;

import android.support.annotation.NonNull;

import com.nepalicoders.daggerrxdatabasemvp.api.CakeApiService;
import com.nepalicoders.daggerrxdatabasemvp.base.BasePresenter;
import com.nepalicoders.daggerrxdatabasemvp.mapper.CakeMapper;
import com.nepalicoders.daggerrxdatabasemvp.mvp.model.Cake;
import com.nepalicoders.daggerrxdatabasemvp.mvp.model.CakesResponse;
import com.nepalicoders.daggerrxdatabasemvp.mvp.model.Storage;
import com.nepalicoders.daggerrxdatabasemvp.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * Created by Sulav on 8/20/17.
 */

public class CakePresenter extends BasePresenter<MainView> implements Observer<CakesResponse> {

    @Inject
    protected CakeApiService mApiService;
    @Inject
    protected CakeMapper mCakeMapper;
    @Inject
    protected Storage mStorage;

    @Inject
    public CakePresenter() {

    }

    public void getCakes() {
        getView().onShowDialog("Loading cakes...");
        Observable<CakesResponse> cakesResponseObservable = mApiService.getCakes();
        subscribe(cakesResponseObservable, this);
    }

    @Override
    public void onNext(@NonNull CakesResponse cakesResponse) {
        List<Cake> cakes = mCakeMapper.mapCakes(mStorage, cakesResponse);
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }

    @Override
    public void onCompleted() {
        getView().onHideDialog();
        getView().onShowToast("Cakes loading complete!");
    }

    @Override
    public void onError(@NonNull Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Error loading cakes " + e.getMessage());
    }

    public void getCakesFromDatabase() {
        List<Cake> cakes = mStorage.getSavedCakes();
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }
}
