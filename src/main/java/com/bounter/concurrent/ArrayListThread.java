package com.bounter.concurrent;

import java.util.ArrayList;

/**
 * Created by admin on 2017/5/18.
 */
public class ArrayListThread implements Runnable {
    public static ArrayList<Integer> intList = new ArrayList<>();

    @Override
    public void run() {
        for (int i=0; i<1000; i++) {
            synchronized (ArrayListThread.class) {
                intList.add(i);
            }
        }
    }
}
