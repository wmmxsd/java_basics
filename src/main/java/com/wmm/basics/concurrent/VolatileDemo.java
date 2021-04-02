package com.wmm.basics.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 增加可重入锁，实现原子性
 * @author wangmingming160328
 * @Description
 * @date @2019/10/18 17:23
 */
public class VolatileDemo {
    //volatile可加可不加，因为reentrantLock本来就具备原子性
    public volatile int inc = 0;
    ReentrantLock reentrantLock = new ReentrantLock(false);

    public void increase() {
        reentrantLock.lock();
        try {
            inc++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        final VolatileDemo test = new VolatileDemo();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000000; j++) {
                    test.increase();
                }
            }).start();
        }

        //保证前面的线程都执行完
        while (Thread.activeCount() > 1) {
            Thread.currentThread().getThreadGroup().list();
            Thread.yield();
        }
        System.out.println(test.inc);
    }
}
