package com.bounter.concurrent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by simon on 2017/5/24.
 */
public class DateFormatThread implements Runnable {
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        try {
            if (threadLocal.get() == null) {
                threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }
            Date date = threadLocal.get().parse("2017-05-24 16:11:22");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
