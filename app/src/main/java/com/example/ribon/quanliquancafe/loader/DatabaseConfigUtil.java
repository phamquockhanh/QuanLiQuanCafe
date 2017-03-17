package com.example.ribon.quanliquancafe.loader;

import com.example.ribon.quanliquancafe.model.Table;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.j256.ormlite.stmt.PreparedDelete;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Ribon on 16/03/2017.
 */


public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    /*private static final Class<?>[] classes = new Class[] {
            Table.class,
    };*/
    public static void main (String [] args) throws Exception {
        writeConfigFile ( "ormlite_config.txt");
    }
}
