package com.wmm.basics.innerclass.nested;

/**
 * @author wangmingming160328
 * @date @2021/1/5 14:37
 */
public class GoodApp {
    public static void main(String[] args) {
        Good good = new Good();
        Good.Logistics logistics = good.new Logistics();
        System.out.println(logistics.now());

        Good.GoodUtils goodUtils = new Good.GoodUtils();
        System.out.println(goodUtils.getName());
    }
}
