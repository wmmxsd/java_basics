package com.wmm.basics;

public class ReturnTest {
    public static void main(String[] args) {
        check(false);
        System.out.println("return后继续执行\r\nmain()");
        System.out.println("return后继续执行\rmain()");
        System.out.println("return后继续执行\n\rmain()");
        System.out.println("return后继续执行\nmain()");
    }

    private static void check(Boolean element){
    }
}
