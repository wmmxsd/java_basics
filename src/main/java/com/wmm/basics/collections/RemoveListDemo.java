package com.wmm.basics.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description 删除List元素Demo
 * @date @2020/5/18 10:58
 */
public class RemoveListDemo {
    private static List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5 ,6);

    public static void remove1() {
        List<Integer> list = new ArrayList<>(integerList);
        for (Integer integer : list) {
            //使用的是ArrayList的remove(Object)方法，会报java.util.ConcurrentModificationException(modCount != expectedModCount)
            list.remove(integer);
        }
    }

    public static void remove2() {
        List<Integer> list = new ArrayList<>(integerList);
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            if (it.next() == 2) {
                //使用的是ArrayList的内部类Itr的remove()方法，会将  expectedModCount = modCount;
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
//        remove1();
        remove2();
    }
}
