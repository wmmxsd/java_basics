package com.wmm.basics.string;

/**
 * @author wangmingming160328
 * @Description new String(String s)方式会创建几个对象？
 * 若常量池有该字符串则创建一个，否则创建2个，但是它本身存储在堆中。
 * 因为形参是一个字符串字面量，所以编译时会直接在常量池中创建该对象，然后运行时再在堆中再创建一个新的String对象，初始化s调用构造函数时会将这个对象作为形参给新对象使用，
 * javap -v out/production/java_basics/com/wmm/basics/string/StringDemo1.class 查看汇编语句
 * @date @2019/10/10 16:36
 */
public class StringDemo1 {
    public static void main(String[] args) {
        String s = new String("2");
    }
}
