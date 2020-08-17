package com.wmm.basics.concurrent;

public class Singleton1Demo {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();
        System.out.println(singleton1 == singleton2);
        Sington3 sington3 = Sington3.INSTANCE;
    }
}
