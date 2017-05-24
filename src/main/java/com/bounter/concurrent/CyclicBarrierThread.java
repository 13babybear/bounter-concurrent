package com.bounter.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by simon on 2017/5/23.
 */
public class CyclicBarrierThread implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            doWork();
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void doWork() throws InterruptedException {
        int time = new Random().nextInt(10)*1000;
        Thread.sleep(time);
        System.out.println("Thread : " + time/1000 + " complete it's task!");
    }
}
