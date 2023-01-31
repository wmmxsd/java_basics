package com.wmm.basics.autobox;

public class BoxDemo {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        //true
        System.out.println(c == d);
        //false
        System.out.println(e == f);
        //true
        System.out.println(c == (a + b));
        //true
        System.out.println(c.equals(a + b));
        //true
        System.out.println(g == (a + b));
        //false
        System.out.println(g.equals(a + b));
    }
}
