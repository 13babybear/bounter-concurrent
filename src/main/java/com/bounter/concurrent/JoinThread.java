package com.bounter.concurrent;

/**
 * Created by admin on 2017/5/18.
 */
public class JoinThread implements Runnable {

    public volatile static int i = 0;

    @Override
    public void run() {
        for (i=0; i<1000; i++) {
        }
    }
}
