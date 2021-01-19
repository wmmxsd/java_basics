package com.wmm.basics.innerclass;

/**
 * @author wangmingming160328
 * @date @2020/12/30 10:28
 */
public class List {
    transient Object[] elementData;
    private int size;
    static int capacity = 1;

    private class Itr {
        //Inner classes cannot have static declarations
        //private static int factory = 1;
        //public static boolean hasNext() {}

        public void resize() {
            size++;
            capacity++;
        }


    }

    class Itr1 {

    }

    public class Itr2 {

    }

    public Itr getItr() {
        return new Itr();
    }

    public Itr1 getItr1() {
        return new Itr1();
    }

    public Itr2 getItr2() {
        return new Itr2();
    }

    public static void main(String[] args) {
        List list = new List();
        Itr itr = list.new Itr();
        itr = list.getItr();

    }
}
