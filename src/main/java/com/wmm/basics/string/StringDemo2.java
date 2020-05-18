package com.wmm.basics.string;

import java.util.Random;

/**
 * intern()方法会将去常量池中找是否存在字符串值相等的对象则返回这个对象的引用；
 * 若不存在，则在常量池中创建一个这样的对象然后返回其引用。
 */
public class StringDemo2 {
    static final int MAX = 1000 * 10000;
    static final String[] arr = new String[MAX];

    public static void main(String[] args) throws Exception {
        Integer[] DB_DATA = new Integer[10];
        Random random = new Random(10 * 10000);
        for (int i = 0; i < DB_DATA.length; i++) {
            DB_DATA[i] = random.nextInt();
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
//         arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length]));
            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern();
        }

        System.out.println((System.currentTimeMillis() - t) + "ms");
        System.gc();
        System.out.println((System.currentTimeMillis() - t) + "ms");
    }
}
