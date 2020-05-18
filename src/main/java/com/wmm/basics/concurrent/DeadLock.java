package com.wmm.basics.concurrent;

/**
 * @author wangmingming160328
 * @Description 死锁
 * @date @2019/10/16 15:54
 */
public class DeadLock{
    private final Object object1 = new Object();
    private Object object2 = new Object();

    private class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object1) {
                System.out.println("Thread1 use object1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println("Thread1 use object2");
                }
            }
        }
    }

    private class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object2) {
                System.out.println("Thread2 use object2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("Thread2 use object1");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
       Thread1 thread1 = deadLock.new Thread1();
       Thread2 thread2 = deadLock.new Thread2();

        thread1.start();
        thread2.start();
    }
}
