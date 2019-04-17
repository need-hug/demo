package com.soft.demo.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: lps
 * DateTime: 2019/4/16 17:19
 * @Version: 1.0
 */
public class DateUtil {

    public static final String pa = "yyyy-MM-dd";

    public static Date currentNow(){
        return Calendar.getInstance().getTime();
    }

}
