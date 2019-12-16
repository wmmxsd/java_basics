package com.wmm.basics.polymorphic;

import com.wmm.basics.extendsandimplements.dog;

public class App extends Student{
    private com.wmm.basics.extendsandimplements.dog dog = new dog();

    public App(int field) {
        super(field);
        System.out.println("App");
    }


    public static void main(String[] args) {
        App app = new App(3);
       /* Person person = new Student(1);
        System.out.println(person.field);
        System.out.println(person.getField());

        Student student = new Student(2);
        System.out.println(student.field);
        System.out.println(student.getField());
        System.out.println(student.getSuperField());*/

    }


}
