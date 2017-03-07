package com.example.ribon.quanliquancafe.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.ribon.quanliquancafe.R;

/**
 * Created by Ribon on 07/03/2017.
 */

public class FragmentUtils {

    public static void replaceFragment(FragmentManager manager, Fragment fragment, boolean addBackStack){
        if(fragment == null || manager == null) return;
        FragmentTransaction transaction = manager.beginTransaction()
                .replace(R.id.activity_main, fragment);
        if(addBackStack){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

}
