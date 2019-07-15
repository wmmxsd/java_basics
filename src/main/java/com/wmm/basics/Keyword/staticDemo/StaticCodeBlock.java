package com.wmm.basics.Keyword.staticDemo;


class StaticCodeBlock<E> {
     Node<E> first;
    Node<E> el;
     Node<E> last;
    public StaticCodeBlock() {
        System.out.print("默认构造方法！--");  //3
    }
    //非静态代码块 2
    {
        System.out.print("非静态代码块！--");
    }
    //静态代码块 1
    static {
        System.out.print("静态代码块！--");
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
        System.out.print("静态方法中的内容! --");
        {
            System.out.print("静态方法中的代码块！--");
        }
        Node<E> node = new Node(first,el,last);
    }

    public static void main(String[] args) {
        StaticCodeBlock test = new StaticCodeBlock();
        test.test();
    }
}
