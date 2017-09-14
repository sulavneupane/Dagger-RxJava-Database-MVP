package com.nepalicoders.daggerrxdatabasemvp.application;

import android.app.Application;

import com.nepalicoders.daggerrxdatabasemvp.dependency_injection.components.ApplicationComponent;
import com.nepalicoders.daggerrxdatabasemvp.dependency_injection.components.DaggerApplicationComponent;
import com.nepalicoders.daggerrxdatabasemvp.dependency_injection.module.ApplicationModule;

/**
 * Created by Sulav on 8/20/17.
 */

public class CakeApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this, "https://gist.githubusercontent.com"))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
