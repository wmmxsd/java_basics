package com.wmm.basics.polymorphic;

public class Student extends Person{



    public Student(int field) {
        super(field);
        this.field = field;
        System.out.println("Student");
    }

    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.getField();
    }

}
