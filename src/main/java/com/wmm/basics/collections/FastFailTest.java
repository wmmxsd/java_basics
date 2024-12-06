package com.wmm.basics.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * @desc java集合中Fast-Fail的测试程序。
 *
 *   fast-fail事件产生的条件：当多个线程对Collection进行操作时，若其中某一个线程通过iterator去遍历集合时，该集合的内容被其他线程所改变；则会抛出ConcurrentModificationException异常。
 *   fast-fail解决办法：通过util.concurrent集合包下的相应类去处理，则不会产生fast-fail事件。
 *
 *   本例中，分别测试ArrayList和CopyOnWriteArrayList这两种情况。ArrayList会产生fast-fail事件，而CopyOnWriteArrayList不会产生fast-fail事件。
 *   (01) 使用ArrayList时，会产生fast-fail事件，抛出ConcurrentModificationException异常；定义如下：
 *            private static List<String> list = new ArrayList<String>();
 *   (02) 使用时CopyOnWriteArrayList，不会产生fast-fail事件；定义如下：
 *            private static List<String> list = new CopyOnWriteArrayList<String>();
 *
 */
public class FastFailTest {

    private static final List<String> list = new ArrayList<>();
    //private static final List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        singleThreadDelete();

        // 同时启动两个线程对list进行操作！
        new ThreadOne().start();
        new ThreadTwo().start();
    }

    /**
     * 单一进程的Fast-Fail集合
     */
    private static void singleThreadDelete() {
        List<Integer> myIntegerList = new ArrayList<>();
        myIntegerList.add(0);
        myIntegerList.add(1);
        myIntegerList.add(2);
        myIntegerList.add(3);
        myIntegerList.add(4);
        myIntegerList.add(5);

        for (Iterator<Integer> it = myIntegerList.iterator(); it.hasNext();) {
            Integer integer = it.next();
            Integer element = Objects.requireNonNull(integer);
            if (2 == element) {
                //若使用List.remove()方法，删除元素之后再次调用next()方法时，modCount != expectedModCount抛出异常
                //若使用Iterator.remove()方法，删除元素之后会执行modCount = expectedModCount语句，这样调用next()方法不会抛出异常。
                //myIntegerList.remove(element);
                it.remove();
            }
        }
    }

    private static void printAll() {
        System.out.println();
        for (String value : list) {
            System.out.print(value + ", ");
        }
    }

    /**
     * 向list中依次添加0,1,2,3,4,5，每添加一个数之后，就通过printAll()遍历整个list
     */
    private static class ThreadOne extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i < 60) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

    /**
     * 向list中依次添加10,11,12,13,14,15，每添加一个数之后，就通过printAll()遍历整个list
     */
    private static class ThreadTwo extends Thread {
        @Override
        public void run() {
            int i = 10;
            while (i < 160) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

}