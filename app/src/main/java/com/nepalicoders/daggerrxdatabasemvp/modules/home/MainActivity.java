package com.nepalicoders.daggerrxdatabasemvp.modules.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.nepalicoders.daggerrxdatabasemvp.R;
import com.nepalicoders.daggerrxdatabasemvp.base.BaseActivity;
import com.nepalicoders.daggerrxdatabasemvp.dependency_injection.components.DaggerCakeComponent;
import com.nepalicoders.daggerrxdatabasemvp.dependency_injection.module.CakeModule;
import com.nepalicoders.daggerrxdatabasemvp.modules.home.adapter.CakeAdapter;
import com.nepalicoders.daggerrxdatabasemvp.mvp.model.Cake;
import com.nepalicoders.daggerrxdatabasemvp.mvp.presenter.CakePresenter;
import com.nepalicoders.daggerrxdatabasemvp.mvp.view.MainView;
import com.nepalicoders.daggerrxdatabasemvp.utilities.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.cake_list)
    protected RecyclerView mCakeList;

    @Inject
    protected CakePresenter mPresenter;

    private CakeAdapter mCakeAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();

        if(NetworkUtils.isNetAvailable(this)) {
            mPresenter.getCakes();
        } else {
            mPresenter.getCakesFromDatabase();
        }

        mPresenter.getCakes();
    }

    private void initializeList() {
        mCakeList.setHasFixedSize(true);
        mCakeList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mCakeAdapter = new CakeAdapter(getLayoutInflater());
        mCakeList.setAdapter(mCakeAdapter);
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerCakeComponent.builder()
                .applicationComponent(getApplicationComponent())
                .cakeModule(new CakeModule(this))
                .build().inject(this);
    }

    @Override
    public void onCakeLoaded(List<Cake> cakes) {
        mCakeAdapter.addCakes(cakes);
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onClearItems() {
        mCakeAdapter.clearCakes();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
