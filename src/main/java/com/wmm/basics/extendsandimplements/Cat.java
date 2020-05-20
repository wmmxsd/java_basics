package com.wmm.basics.extendsandimplements;

public class Cat extends AbstractAnimal{
    public Cat(int i) {
        this.i = i;
    }

    private int i = 10;

    @Override
    void print() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        Cat cat = new Cat(10);
        cat.print();
    }
}
