package com.example.ribon.quanliquancafe.loader;

import android.content.Context;

/**
 * Created by Ribon on 16/03/2017.
 */

public class DatabaseManager extends DatabaseHelper {
    private DatabaseHelper helper;

    public DatabaseManager(Context context) {
        super(context);
        helper=new DatabaseHelper(context);
    }

    public DatabaseHelper getHelper() {
        return helper;
    }
}
