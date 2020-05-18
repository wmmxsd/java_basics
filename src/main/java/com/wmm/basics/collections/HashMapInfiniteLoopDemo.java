package com.wmm.basics.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * jdk必须小于1.8
 *
 * @author wangmingming160328
 * @Description hashMap多线程下死循环demo
 * @date @2020/5/18 15:28
 */
public class HashMapInfiniteLoopDemo {
    private static Map<Integer, String> map = new HashMap<>(2, 0.75F);

    public static void main(String[] args) {

        map.put(5, "C");
        new Thread(() -> {
            map.put(7, "B");
            System.out.println(map);
        }, "thread1").start();

        new Thread(() -> {
            map.put(3, "A");
            System.out.println(map);
        }, "thread2").start();
    }
}
