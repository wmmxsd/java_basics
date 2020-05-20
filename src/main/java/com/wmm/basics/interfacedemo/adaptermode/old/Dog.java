package com.wmm.basics.interfacedemo.adaptermode.old;

public class Dog extends Animals{
    @Override
    public void eat() {
        System.out.println(this.getClass().getSimpleName() + " eat");
    }
}
