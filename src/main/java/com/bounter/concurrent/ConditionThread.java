package com.bounter.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by simon on 2017/5/24.
 */
public class ConditionThread implements Runnable {
    private ReentrantLock lock;
    private Condition condition;

    public ConditionThread(ReentrantLock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("线程" + Thread.currentThread().getName() + "进入等待！");
            condition.await();
            System.out.println("线程" + Thread.currentThread().getName() + "恢复执行！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
