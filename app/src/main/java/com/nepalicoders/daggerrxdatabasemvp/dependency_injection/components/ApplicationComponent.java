package com.nepalicoders.daggerrxdatabasemvp.dependency_injection.components;

import android.content.Context;

import com.nepalicoders.daggerrxdatabasemvp.dependency_injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Sulav on 8/20/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();

}
