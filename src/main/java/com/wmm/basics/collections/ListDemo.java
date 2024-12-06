package com.wmm.basics.collections;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        ((ArrayList<?>) list).trimToSize();
        list.add(null);
        list.add("321");
        list.add("123");
        list.add(1,123);
        list.removeIf("123"::equals);
        list.replaceAll(o -> {
            if ("123".equals(o)) {
                o = "111";
            }
            return o;
        });
        list.set(0, "111");
        list.sort(Comparator.comparing(o -> Integer.parseInt(o.toString())));
        Collections.sort(list, (o1, o2) -> 0);
        for (int i = 0; i < list.size(); i++){
            Object s = list.get(i);
            System.out.println(s);
        }

        String[] array1 = list.stream().map(Object::toString).toArray(String[]::new);
    }
}
