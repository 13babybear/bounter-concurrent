package com.bounter.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 2017/5/18.
 */
public class ReentrantLockThread implements Runnable {
    //可重入锁,尽量声明为static来保证多个ReentrantLockThread实例共用一个锁
    private  static ReentrantLock lock = new ReentrantLock();
    //计数器
    public static int count = 0;

    @Override
    public void run() {
        for (int i=0; i<10000; i++) {
            try {
                //加锁
                lock.lock();
                count ++;
            } finally {
                //解锁
                lock.unlock();
            }
        }
    }
}
