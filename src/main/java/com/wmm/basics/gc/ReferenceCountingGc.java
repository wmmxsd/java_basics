package com.wmm.basics.gc;

public class ReferenceCountingGc {
    Object instance = null;
    public static void main(String[] args) {
        /*ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;*/
        byte[] allocation1, allocation2;
        allocation1 = new byte[52900*1024];
        allocation2 = new byte[9000*1024];
    }
}
