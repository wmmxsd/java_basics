package com.wmm.basics.polymorphic;

public class Person {
    public int field = 0;

    public Person(int field) {
        this.field = field;
        System.out.println("Person");
    }

    public int getField() {
        return field;
    }
}
