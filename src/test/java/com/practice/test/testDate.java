package com.practice.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vyast3 on 1/17/15.
 */
public class testDate {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = sdf.format(new Date());
        System.out.println(date); //15/10/2013

    }
}
