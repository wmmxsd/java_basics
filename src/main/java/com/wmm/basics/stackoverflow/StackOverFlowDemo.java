package com.wmm.basics.stackoverflow;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/8/23 18:46
 */
public class StackOverFlowDemo {
    public static void main(String[] args) {
        recursive();
    }

    /**
     * Exception in thread "main" java.lang.StackOverflowError
     */
    private static void recursive() {
        for (;;) {
            recursive();
        }
    }

}
