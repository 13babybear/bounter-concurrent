package com.bounter;

import com.bounter.concurrent.CyclicBarrierThread;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by simon on 2017/5/23.
 */
public class CyclicBarrierApp {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier Action now!");
            }
        });

        System.out.println("Begin Task...");
        for (int i=0; i<10; i++) {
            new Thread(new CyclicBarrierThread(cyclicBarrier)).start();
        }
    }
}
