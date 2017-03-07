package com.example.ribon.quanliquancafe.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ribon on 07/03/2017.
 */

public class DateUtils {

    public static String formatDate(Date date, String format){
        if(date == null || format == null || format.isEmpty()) return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }

}
