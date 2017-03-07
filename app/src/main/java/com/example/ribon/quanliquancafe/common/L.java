package com.example.ribon.quanliquancafe.common;

import android.util.Log;

/**
 * Created by Ribon on 07/03/2017.
 */

public class L {

    public static final boolean DEBUG = false;
    public static final String TAG = "quanlycf";

    public static void d(String tag, String mesage){
        if(DEBUG)
            Log.d(tag, mesage);
    }

    public static void d(String message){
        L.d(TAG, message);
    }

    public static void e(String tag, String mesage){
        if(DEBUG)
            Log.e(tag, mesage);
    }

    public static void e(String message){
        L.e(TAG, message);
    }

    public static void i(String tag, String mesage){
        if(DEBUG)
            Log.i(tag, mesage);
    }

    public static void i(String message){
        L.i(TAG, message);
    }
}
