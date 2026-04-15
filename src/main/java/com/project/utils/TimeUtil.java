package com.project.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    static void main() {
        System.out.println(getTimestamp());
    }

    public static String getTimestamp() {
        Date date = new Date();
        System.out.println(date);
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);
    }
}
