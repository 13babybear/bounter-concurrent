package com.bounter.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by simon on 2017/5/22.
 */
public class CountDownLatchThread implements Runnable {
//    public static CountDownLatch doneSignal = new CountDownLatch(10);
    public static CountDownLatch startSignal = new CountDownLatch(1);

    @Override
    public void run() {
//        try {
//            int time = new Random().nextInt(10)*1000;
//            Thread.sleep(time);
//            System.out.println("A Thread with time: " + time/1000 + " count down!");
//            //标识当前线程执行完成
//            doneSignal.countDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //所有线程同时开始执行工作，可以用来模拟并发
        try {
            startSignal.await();
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doWork() {
        System.out.println("Access site: www.bounter.com");
    }
}
