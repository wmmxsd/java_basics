package com.wmm.basics.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/18 17:23
 */
public class VolatileDemo {

    public AtomicInteger inc = new AtomicInteger(0);

    ReentrantLock reentrantLock = new ReentrantLock(false);

    public void increase() {
        reentrantLock.lock();
        try {
            inc.getAndIncrement();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        final VolatileDemo test = new VolatileDemo();
        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    for(int j=0;j<1000;j++) {
                        test.increase();
                    }
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
        {
            Thread.yield();
        }
        System.out.println(test.inc);
    }
}
