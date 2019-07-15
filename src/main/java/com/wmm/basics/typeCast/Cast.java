package main.java.com.wmm.basics.typeCast;

public class Cast {
    public static void main(String[] args) {
        //Son对象向上转型，不能使用Son特有的方法。
        Father father = new Son();
        father.eat();
        //father.sit();

        //向下强转恢复为Son对象，可以使用Son对象特有方法。
        Son son = (Son)father;
        son.sit();

        Father father1 = new Father();
        Son son1 = (Son)father1;
    }
}
