package com.wmm.basics.innerclass;

/**
 * 内部类被其他类引用时权限的表现跟普通类一样
 * @author wangmingming160328
 * @date @2020/12/30 10:43
 */
public class ListApp {
    public static void main(String[] args) {
        List list = new List();
        //'com.wmm.basics.innerclass.List.Itr' has private access in 'com.wmm.basics.innerclass.List'
        //List.Itr itr =list.new Itr();
        List.Itr1 itr1 = list.new Itr1();
        List.Itr2 itr2 = list.new Itr2();
    }
}
