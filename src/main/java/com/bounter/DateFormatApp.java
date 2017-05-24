package com.bounter;

import com.bounter.concurrent.DateFormatThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by simon on 2017/5/24.
 */
public class DateFormatApp {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i=0; i<1000; i++) {
            executorService.execute(new DateFormatThread());
        }

        executorService.shutdown();
    }
}
