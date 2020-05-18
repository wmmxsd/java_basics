package com.wmm.basics.interfacedemo.interface_implement_interface;

import com.wmm.basics.polymorphic.Student;

public class Person extends Student implements Live{
    public Person(int field) {
        super(field);
    }

    @Override
    public void live() {

    }

    @Override
    public void drink() {

    }

    @Override
    public void eat() {

    }

    public void drinkAction(Drink drink) {
        drink.drink();
    }

    public void eatAction(Eat eat) {
        eat.eat();
    }

    public void liveAction(Live live){
        live.live();
        live.drink();
        live.eat();
    }
    public static void main(String[] args) {
        Person person = new Person(1);
        person.drinkAction(person);
        person.eatAction(person);
        person.liveAction(person );
    }
}
