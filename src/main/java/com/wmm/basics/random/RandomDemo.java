package com.wmm.basics.random;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author wangmingming160328
 * @date @2021/1/19 16:27
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        //所有2^32个可能的int值都是（近似）相等的概率产生的
        IntStream.range(0, 10).forEach(value -> System.out.print(random.nextInt() + " "));
        System.out.println();
        //其int值均匀地分布在0（含）和指定值（不含）之间
        IntStream.range(0, 10).forEach(value -> System.out.print(random.nextInt(4) + " "));
        System.out.println();
        //如果使用相同的seed()值，则每次生成的随机数都相同；如果不设置这个值，则系统会根据时间来自己选择这个值，此时每次生成的随机数会因时间的差异而有所不同。
        Random random1 = new Random(47);
        IntStream.range(0, 10).forEach(value -> System.out.print(random1.nextInt() + " "));
        System.out.println();
        IntStream.range(0, 10).forEach(value -> System.out.print(random1.nextInt(4) + " "));
    }
}
