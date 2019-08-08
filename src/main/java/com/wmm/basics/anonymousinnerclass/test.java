package com.wmm.basics.anonymousinnerclass;

public class test {
    public static void main(String[] args) {
        //匿名内部类用于抽象类
        Person person = new Person() {
            @Override
            public void eat() {
                System.out.println("大朗吃药了");
            }
        };
        person.eat();

        //匿名内部类用于接口
        People people = () -> System.out.println("大朗请坐");
        people.sit();

        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(i + " ");
                }
            }
        };
        thread.run();
    }
}
