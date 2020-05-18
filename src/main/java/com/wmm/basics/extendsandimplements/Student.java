package com.wmm.basics.extendsandimplements;

public class Student extends People{
    private String name;
    public Student(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Student student = new Student("WangMingMing");
        student.eat();
    }
}
