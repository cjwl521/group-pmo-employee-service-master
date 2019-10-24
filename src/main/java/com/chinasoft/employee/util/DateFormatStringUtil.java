package com.chinasoft.employee.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatStringUtil {

    private static String DATE_STRING = "yyyy-MM-dd HH:mm:ss";

    public static String dateForString(Date date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_STRING);

        return dateFormat.format(date);
    }
}
