package com.bounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by simon on 2017/5/21.
 */
public class ReadWriteLockApp {
    //普通锁
    private static Lock lock = new ReentrantLock();

    //读写锁
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    private int someValue;

    private int readSomething(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            return someValue;
        } finally {
            lock.unlock();
        }
    }

    private void writeSomething(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            someValue ++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockApp app = new ReadWriteLockApp();
        long startTime = System.nanoTime();

        Runnable readThread = new Runnable() {
            @Override
            public void run() {
                try {
                    app.readSomething(readLock);
                    //app.readSomething(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeThread = new Runnable() {
            @Override
            public void run() {
                try {
                    app.writeSomething(writeLock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //启动读和写线程
        Thread t;
        for (int i=0; i<18; i++) {
            t = new Thread(readThread);
            t.start();
        }
        for (int i=18; i<20; i++) {
            t = new Thread(writeThread);
            t.start();
        }

    }
}
