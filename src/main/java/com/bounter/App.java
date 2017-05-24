package com.bounter;

import com.bounter.concurrent.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
//        JoinThread joinThread = new JoinThread();
//        Thread thread = new Thread(joinThread);
//        thread.start();
//        //如果没有join，将输出0
//        thread.join();
//        System.out.println(joinThread.i);

//        Thread t1 = new Thread(new ArrayListThread());
//        Thread t2 = new Thread(new ArrayListThread());
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(ArrayListThread.intList.size());

//        Thread t1 = new Thread(new ReentrantLockThread());
//        Thread t2 = new Thread(new ReentrantLockThread());
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(ReentrantLockThread.count);

//        for (int i=0; i<20; i++) {
//            new Thread(new SemaphoreThread()).start();
//        }

        for (int i=0; i<10; i++) {
            new Thread(new CountDownLatchThread()).start();
        }
        Thread.sleep(1000);
        CountDownLatchThread.startSignal.countDown();

        //当前线程等待countDownLatch上的所有线程执行完成
//        CountDownLatchThread.doneSignal.await();
        System.out.println("GO!");


    }
}
