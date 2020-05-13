package com.wmm.basics.keyword.finalDemo.initialization;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/5/13 16:18
 */
public class FinalDemo3 {
    private final String test = "helloWorld";

    public String getTest() {
        return test;
    }

    public static void main(String[] args) {
        FinalDemo3 finalDemo3 = new FinalDemo3();
        System.out.println(finalDemo3.getTest());
    }
}
