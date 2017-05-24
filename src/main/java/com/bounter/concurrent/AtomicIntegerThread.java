package com.bounter.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by simon on 2017/5/24.
 */
public class AtomicIntegerThread implements Runnable {
    public static AtomicInteger atomicInteger = new AtomicInteger();

    //如果直接用Integer则多个线程累加的总和会小于10000
    //public static Integer integer = 0;

    @Override
    public void run() {
        for (int i=0; i<1000; i++) {
            atomicInteger.incrementAndGet();
            //integer ++;
        }
    }
}
