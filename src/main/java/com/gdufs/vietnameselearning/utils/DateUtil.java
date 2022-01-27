package com.gdufs.vietnameselearning.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    //    日期转字符串
    public static String dateToString(Date day){
        return dateToString(day,"yyyy-MM-dd");
    }

    //    自定义字符串格式
    public static String dateToString(Date day,String pattern){
        SimpleDateFormat sp=new SimpleDateFormat(pattern);
        return sp.format(day);
    }

    //    获取昨天日期字符串
    public static String getYestoday(Date today){
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = c.getTime();//这是昨天
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        return sp.format(yesterday);
    }



}
