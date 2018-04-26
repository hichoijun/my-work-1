package com.cj.ggs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getNow() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }


    public static void main(String[] args) {
        System.out.println(getNow());
    }
}
