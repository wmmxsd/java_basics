package com.wmm.basics.extendsandimplements.test2;

public class EnglishTeacher extends AbstractTeacher{
    public static void teach() {
        AbstractTeacher teacher = new EnglishTeacher();
        ((EnglishTeacher)teacher).test();
    }

    public void test(){
        System.out.println("english test");
    }

    public static void main(String[] args) {
        EnglishTeacher.teach();
    }
}
