package com.wmm.basics.interfacedemo.adaptermode.old;

public class Bird extends Animals{
    @Override
    public void eat() {
        System.out.println(this.getClass().getSimpleName() + " eat");
    }
}
