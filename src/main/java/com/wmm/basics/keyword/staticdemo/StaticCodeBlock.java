package com.wmm.basics.keyword.staticdemo;


import com.wmm.basics.polymorphic.Person;

class StaticCodeBlock<E> extends Person {
    private Integer i = 2;
    private static Integer i1 = 2;
    Node<E> first;
    Node<E> el;
    Node<E> last;
    static String s = "1";

    public StaticCodeBlock() {
        super(2);
        System.out.println("默认构造方法！--");  //3
    }

    //非静态代码块 2
    {
        System.out.println("非静态代码块！--");
    }

    //静态代码块 1
    static {
        System.out.println("静态代码块！--");
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void test() {    //4
        System.out.println("静态方法中的内容! --");
        {
            System.out.println("静态方法中的代码块！--");
        }
        Node<E> node = new Node(first, el, last);
    }

    public static void main(String[] args) {
        StaticCodeBlock<Integer> test = new StaticCodeBlock<>();
        test.test();
    }
}
