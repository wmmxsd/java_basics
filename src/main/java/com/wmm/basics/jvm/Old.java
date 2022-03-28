package com.wmm.basics.jvm;

/**
 * 大对象直接进入老年代
 *  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseParNewGC -XX:PretenureSizeThreshold=3145728
 *  Heap
 *  par new generation   total 9216K, used 1311K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 *   eden space 8192K,  16% used [0x00000000fec00000, 0x00000000fed47fd8, 0x00000000ff400000)
 *   from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
 *   to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 *  tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 *    the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00010, 0x00000000ffa00200, 0x0000000100000000)
 *  Metaspace       used 2625K, capacity 4486K, committed 4864K, reserved 1056768K
 *   class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
 */
public class Old {
    private static final int _1MB = 1024 * 1024;

    public static void testPretenureSizeThreshold() {
        byte[] allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        //我们看到Eden空间几乎没有被使用，而 老年代的10MB空间被使用了40%，也就是4MB的allocation对象直接就分配在老年代中
        Old.testPretenureSizeThreshold();
    }
}
