package com.nepalicoders.daggerrxdatabasemvp.mapper;

import com.nepalicoders.daggerrxdatabasemvp.mvp.model.Cake;
import com.nepalicoders.daggerrxdatabasemvp.mvp.model.CakesResponse;
import com.nepalicoders.daggerrxdatabasemvp.mvp.model.CakesResponseCakes;
import com.nepalicoders.daggerrxdatabasemvp.mvp.model.Storage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Sulav on 8/20/17.
 */

public class CakeMapper {

    @Inject
    public CakeMapper() {

    }

    public List<Cake> mapCakes(Storage storage, CakesResponse response) {
        List<Cake> cakeList = new ArrayList<>();

        if (response != null) {
            CakesResponseCakes[] responseCakes = response.getCakes();
            if (responseCakes != null) {
                for (CakesResponseCakes cake : responseCakes) {
                    Cake myCake = new Cake();
                    myCake.setId(cake.getId());
                    myCake.setTitle(cake.getTitle());
                    myCake.setPreviewDescription(cake.getPreviewDescription());
                    myCake.setDetailDescription(cake.getDetailDescription());
                    myCake.setImage(cake.getImage());
                    storage.addCake(myCake);
                    cakeList.add(myCake);
                }
            }
        }

        return cakeList;
    }

}
