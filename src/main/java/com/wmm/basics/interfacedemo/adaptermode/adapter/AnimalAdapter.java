package com.wmm.basics.interfacedemo.adaptermode.adapter;

import com.wmm.basics.interfacedemo.adaptermode.old.Animals;

public class AnimalAdapter implements Adapter{
    private Animals animals;

    public AnimalAdapter(Animals animals) {
        this.animals = animals;
    }

    @Override
    public void request() {
        animals.eat();
    }
}
