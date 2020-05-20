package com.wmm.basics.interfacedemo.adaptermode;

import com.wmm.basics.interfacedemo.adaptermode.adapter.AnimalAdapter;
import com.wmm.basics.interfacedemo.adaptermode.old.Bird;
import com.wmm.basics.interfacedemo.adaptermode.old.Dog;

public class App {
    public static void main(String[] args) {
        AnimalAdapter animalA = new AnimalAdapter(new Bird());
        AnimalAdapter animalB = new AnimalAdapter(new Dog());
        animalA.request();
        animalB.request();
    }
}
