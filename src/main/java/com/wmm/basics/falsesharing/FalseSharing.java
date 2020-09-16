package com.wmm.basics.falsesharing;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

/**
 * 伪共享：
 * cpu具有多级缓存L1,L2...Ln，其中Ln为多核共享，以缓存行作为数据读取的基本单位，多个核的线程在操作同一个缓存行中的不同变量数据，就会出现频繁的缓存失效，这就是伪共享
 *
 * @author wangmingming160328
 * @date @2020/9/16 10:21
 */
public class FalseSharing implements Runnable {
    /**线程数量**/
    public static int NUM_THREADS = 4;
    /**赋值循环次数**/
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    /**longs数组的下标**/
    private final int arrayIndex;
    private static VolatileLong[] longs;

    public FalseSharing(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    private static final class VolatileLong {
        private volatile long value = 0L;
        //缓存行填充
        //一条缓存行有64字节，而Java程序的对象头固定占8字节(32位系统)或12字节(64位系统默认开启压缩,不开压缩为16字节)，
        // 所以我们只需要填6个无用的长整型补上6*8=48字节，让不同的VolatileLong对象处于不同的缓存行，就避免了伪共享。
        private long l1, l2, l3, l4, l5, l6;
    }

    /**
     * n个线程分别循环修改下标为arrayIndex的VolatileLong对象的value字段ITERATIONS次
     */
    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while (--i > 0) {
            longs[arrayIndex].value = i;
        }
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharing(i));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //执行10次
        long time = 0L;
        for (int j = 0; j < 10; j++) {
            System.out.println(j);
            longs = new VolatileLong[NUM_THREADS];
            for (int i = 0; i < longs.length; i++) {
                longs[i] = new VolatileLong();
            }
            final long start =System.nanoTime();
            runTest();
            final long end = System.nanoTime();
            time += end - start;
        }
        System.out.println("平均耗时：" + time);
    }
}
