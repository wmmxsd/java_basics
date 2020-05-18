package com.wmm.basics.keyword.finalDemo.initialization;

/**
 * 若属性被修饰为final,只有当类被实例化的时候这个属性才被分配内存空间，实例化时需要执行代码块，构造函数等，所以属性就可以被初始化
 * @author wangmingming160328
 * @Description
 * @date @2020/5/13 16:06
 */
public class FinalDemo1 {
    private final String test;

    public FinalDemo1() {
        this.test = "helloWorld";
    }

    public String getTest() {
        return test;
    }

    public static void main(String[] args) {
        FinalDemo1 demo = new FinalDemo1();
        System.out.println(demo.test);
    }
}
