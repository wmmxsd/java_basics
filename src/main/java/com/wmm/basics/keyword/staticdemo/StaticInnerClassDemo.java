package com.wmm.basics.keyword.staticdemo;

/**
 * 区别：
 * 1.静态内部类不能访问外部类的非静态的成员和方法，只能访问外部类的静态属性。而非静态内部类可以访问外部类的全部属性。
 * 2.静态内部类可以定义静态成员和方法，但是非静态内部类不行。
 * 3.实例化静态内部类不需要实例化外部类，直接实例化自己。而非静态内部类需要先实例化外部类，再实例化自己。
 *
 * @author wangmingming160328
 * @Description
 * @date @2020/5/20 15:28
 */
public class StaticInnerClassDemo {
    private String str1 = "1";
    private static String str2 = "2";

    public void test() {
        System.out.println("test");
    }

    public static void test1() {
        System.out.println("test1");
    }
    public class InnerClass{
        private String str3 = str1;
        private String str4 = str2;
        //Inner classes cannot have static declarations
        //private static String staticStr = str2;

        public void test2() {
            test();
        }

        public void test3() {
            test1();
        }
    }

    public static class StaticInnerClass{
        //Non-static field 'str1' cannot be referenced from a static context
        //private String str5 = str1;
        private String str6 = str2;
        private static String str7 = str2;

        public void test4() {
            //Non-static method 'test()' cannot be referenced from a static contex
            //test();
        }

        public void test5() {
            test1();
        }
    }

    public static void main(String[] args) {
        StaticInnerClassDemo staticInnerClassDemo = new StaticInnerClassDemo();
        InnerClass innerClass = staticInnerClassDemo.new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClassDemo.StaticInnerClass();
    }
}
