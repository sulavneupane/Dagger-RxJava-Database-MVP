package com.nepalicoders.daggerrxdatabasemvp.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Sulav on 8/23/17.
 */

public class NetworkUtils {

    public static boolean isNetAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo allNetworkInfo[] = connectivityManager.getAllNetworkInfo();
        for(NetworkInfo ni: allNetworkInfo) {
            if(ni.getTypeName().equalsIgnoreCase("WIFI"))
                if(ni.isConnected())
                    return true;
            if(ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if(ni.isConnected())
                    return true;
        }

        return false;
    }

}
