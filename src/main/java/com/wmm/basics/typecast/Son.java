package com.wmm.basics.typecast;

import com.wmm.basics.extendsandimplements.Runner;

public class Son extends Father implements Runner {
    public void sit(){
        System.out.println("son sit");
    }

    @Override
    public void run() {

    }
}

