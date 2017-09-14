package com.nepalicoders.daggerrxdatabasemvp.dependency_injection.module;

import com.nepalicoders.daggerrxdatabasemvp.api.CakeApiService;
import com.nepalicoders.daggerrxdatabasemvp.dependency_injection.scope.PerActivity;
import com.nepalicoders.daggerrxdatabasemvp.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Sulav on 8/20/17.
 */

@Module
public class CakeModule {

    private MainView mView;

    public CakeModule(MainView view) {
        mView = view;
    }

    @PerActivity
    @Provides
    CakeApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(CakeApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideView() {
        return mView;
    }

}
