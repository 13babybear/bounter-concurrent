package com.bounter;

import com.bounter.concurrent.AtomicIntegerThread;

/**
 * Created by simon on 2017/5/24.
 */
public class AtomicIntegerApp {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i=0; i<10; i++) {
            threads[i] = new Thread(new AtomicIntegerThread());
            threads[i].start();
        }

        for(Thread t : threads) {
            t.join();
        }

        System.out.println(AtomicIntegerThread.atomicInteger);
//        System.out.println(AtomicIntegerThread.integer);
    }
}
