package com.nepalicoders.daggerrxdatabasemvp.dependency_injection.components;

import com.nepalicoders.daggerrxdatabasemvp.dependency_injection.module.CakeModule;
import com.nepalicoders.daggerrxdatabasemvp.dependency_injection.scope.PerActivity;
import com.nepalicoders.daggerrxdatabasemvp.modules.home.MainActivity;

import dagger.Component;

/**
 * Created by Sulav on 8/20/17.
 */

@PerActivity
@Component(modules = CakeModule.class, dependencies = ApplicationComponent.class)
public interface CakeComponent {

    void inject(MainActivity activity);

}
