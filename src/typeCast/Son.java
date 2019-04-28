package typeCast;

import extendsAndImplements.Runner;

public class Son extends Father implements Runner {
    public void sit(){
        System.out.println("son sit");
    }

    @Override
    public void run() {

    }
}

