package main.java.com.wmm.basics.Collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(1,2);
        linkedList.addFirst(3);
       linkedList.addLast(4);
       LinkedList linkedList1 = new LinkedList();
       linkedList1.addAll(0,linkedList);
       //linkedList.clear();
        LinkedList linkedList2 = (LinkedList) linkedList1.clone();
        for (Iterator iter = linkedList.iterator(); iter.hasNext();){
            System.out.println(iter.next());
        }
        linkedList2.indexOf(1);
        linkedList2.lastIndexOf(linkedList2.getLast());
        linkedList2.get(3);
        int i = (int) linkedList.peek();
        /*linkedList.poll();
        linkedList.pollFirst();
        linkedList.pollLast();*/
        linkedList.push(6);
        linkedList.pop();
        linkedList.remove(new Integer(4));
    }
}
