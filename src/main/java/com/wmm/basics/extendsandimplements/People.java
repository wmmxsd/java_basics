package com.wmm.basics.extendsandimplements;

public class People {
    private String name;

    public People(String name) {
        this.name = name;
    }

    protected void eat(){
        System.out.println(name + " is eating!");
    }
}
