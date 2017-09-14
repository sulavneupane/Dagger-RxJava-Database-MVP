package com.nepalicoders.daggerrxdatabasemvp.mvp.view;

import com.nepalicoders.daggerrxdatabasemvp.base.BaseView;
import com.nepalicoders.daggerrxdatabasemvp.mvp.model.Cake;

import java.util.List;

/**
 * Created by Sulav on 8/20/17.
 */

public interface MainView extends BaseView {

    void onCakeLoaded(List<Cake> cakes);

    void onShowDialog(String message);

    void onShowToast(String message);

    void onHideDialog();

    void onClearItems();
}
