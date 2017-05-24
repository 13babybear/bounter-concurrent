package com.bounter.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by simon on 2017/5/21.
 */
public class SemaphoreThread implements Runnable {
    private static Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " finished!");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
