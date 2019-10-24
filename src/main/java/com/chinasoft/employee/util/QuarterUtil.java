package com.chinasoft.employee.util;

import java.util.Calendar;
/**
 * 季度工具类
 * @author wang
 *
 */
public class QuarterUtil {

    
    @SuppressWarnings("null")
    public static String[] generalYearAndQuarter(){
        String[] strings = new String[2];
        Calendar rightNow = Calendar.getInstance();
        int monthNow = rightNow.get(Calendar.MONTH);
        int yearNow = rightNow.get(Calendar.YEAR);
        if(monthNow<3){
            strings[0] = yearNow-1+","+4;
            strings[1] = yearNow-1+","+3;
        }else if(monthNow>=3 & monthNow < 6){
            strings[0] = yearNow+","+ 1;
            strings[1] = yearNow-1+","+ 4;
        }else if(monthNow>=6 & monthNow < 9){
            strings[0] = yearNow+","+ 2;
            strings[1] = yearNow+","+ 1;
        }else if(monthNow>=9 & monthNow <= 11){
            strings[0] = yearNow+","+ 3;
            strings[1] = yearNow+","+ 2;
        }
        return strings;
    }
}
