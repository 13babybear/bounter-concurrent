package com.bounter;

import com.bounter.concurrent.ConditionThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by simon on 2017/5/24.
 */
public class ConditionApp {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t = new Thread(new ConditionThread(lock,condition));
        t.start();

        Thread.sleep(1000);

        lock.lock();
        System.out.println("唤醒线程" + t.getName());
        condition.signal();
        lock.unlock();
    }
}
