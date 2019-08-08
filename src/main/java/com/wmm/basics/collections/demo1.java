package com.wmm.basics.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        ((ArrayList) list).trimToSize();
        list.add("321");
        list.add("123");
        list.add(1,123);
        list.removeIf(s -> s.equals("123"));
        list.replaceAll(o -> {
            if (o.toString().equals("123")) {
                o = "111";
            }
            return o;
        });
        list.sort(Comparator.comparing(o -> Integer.valueOf((String) o)));
        Collections.sort(list, (o1, o2) -> 0);
        ArrayList arrayList = (ArrayList) ((ArrayList) list).clone();
        for (int i = 0; i < list.size(); i++){
            Object s = list.get(i);
            System.out.println(s);
        }
        //String[] s1 = (String[]) list.toArray();
        String[] s = (String[]) list.toArray(new String[list.size()]);

        Object object1 = new Object();
       // object1 = (Integer)object1;
        object1.toString();

        Object object2 = new Integer(2);
        object2 = (Integer)object2;
        ((Integer) object2).compareTo(2);
    }
}
