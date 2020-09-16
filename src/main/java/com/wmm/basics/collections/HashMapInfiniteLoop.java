package com.wmm.basics.collections;

import java.util.HashMap;

/**
 * 多线程场景下map死循环
 * @author wangmingming160328
 * @date @2020/9/15 10:33
 */
public class HashMapInfiniteLoop {
    private static final HashMap<Integer, String> MAP = new HashMap<>(2, 0.75f);

    public static void main(String[] args) {
        MAP.put(5, "C");

        new Thread("Thread1") {
            @Override
            public void run() {
                MAP.put(7, "B");
                System.out.println(MAP);
            }
        }.start();

        new Thread("Thread2") {
            @Override
            public void run() {
                MAP.put(3, "A");
                System.out.println(MAP);
            }
        }.start();
    }
}
