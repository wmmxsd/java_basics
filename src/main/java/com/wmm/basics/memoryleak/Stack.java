package com.wmm.basics.memoryleak;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 内存泄露：内存被程序使用后得不到释放使不可用内存一直堆积，最后导致可用内存越来越少，导致内存溢出
 * 内存溢出：程序请求的内存超过可分配的内存，导致内存溢出
 */
public class Stack<T> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    /**
     * pop操作时，由于elements[--size]的引用未进行置空，gc是不会释放的
     * @return
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (T) elements[--size];
    }

    @SuppressWarnings("unchecked")
    public T popWithOutMemoryLeak() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T t = (T) elements[--size];
        elements[size] = null;
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        Stack<Long> stack = new Stack<>();
        System.out.println("push start");
        for (long i = 0; i < 100000000; i++) {
            stack.push(i);
        }
        System.out.println("push end");
        System.out.println("pop start");
        while (stack.size > 0) {
            stack.popWithOutMemoryLeak();
            //stack.pop();
        }
        System.out.println("pop end");
        Thread.sleep(100000);
        System.out.println("over");
    }
}
