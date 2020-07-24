package com.wmm.basics.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangmingming160328
 * @date @2020/7/24 11:49
 */
public class ComparatorApp {
    public static void main(String[] args) {
        Child child3 = new Child(3, 10);
        Child child1 = new Child(1, 14);
        Child child2 = new Child(2, 12);

        List<Child> list = new ArrayList<>();
        list.add(child2);
        list.add(child3);
        list.add(child1);

        list.sort(Comparator.comparing(Child::getAge));
    }
}
