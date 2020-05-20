package com.wmm.basics.keyword.staticdemo;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/5/20 15:36
 */
public class App {
    public static void main(String[] args) {
        StaticInnerClassDemo.StaticInnerClass staticInnerClass = new StaticInnerClassDemo.StaticInnerClass();
        StaticInnerClassDemo.InnerClass innerClass = new StaticInnerClassDemo().new InnerClass();
    }
}
