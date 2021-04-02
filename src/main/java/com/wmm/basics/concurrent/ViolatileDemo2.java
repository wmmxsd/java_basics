package com.wmm.basics.concurrent;

/**
 * volatile不具备原子性
 * @author wangmingming160328
 * @Description
 * @date @2019/10/21 10:50
 */
public class ViolatileDemo2 {
    public static volatile int t = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            //每个线程对t进行1000次加1的操作
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    t = t + 1;
                }
            });
            threads[i].start();
        }

        //等待所有累加线程都结束
        while (Thread.activeCount() > 1) {
            Thread.currentThread().getThreadGroup().list();
            Thread.yield();
        }

        //打印t的值
        System.out.println(t);
    }
}
