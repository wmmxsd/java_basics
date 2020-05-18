package com.wmm.basics.keyword.finalDemo.initialization;

/**
 *
 * 若属性被修饰为final,只有当类被实例化的时候这个属性才被分配内存空间，实例化时需要执行代码块，构造函数等，所以属性就可以被初始化
 * @author wangmingming160328
 * @Description
 * @date @2020/5/13 16:15
 */
public class FinalDemo2 {
    private  final String test;

    {
        this.test = "helloWorld";
    }

    public String getTest() {
        return test;
    }

    public static void main(String[] args) {
        FinalDemo2 finalDemo2 = new FinalDemo2();
        System.out.println(finalDemo2.getTest());
    }
}
