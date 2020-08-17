package com.wmm.basics.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/7/9 23:09
 */
public class Test {
    class GenericTest<T> {
        T getElement (List<T> list) {
            return list.get(0);
        }
    }

    class NonGenericTest {
        <T>T getElement (List<T> list) {
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Test.GenericTest<String> genericTest = test.new GenericTest<>();
        List<String> list = Collections.singletonList("1");
        //genericTest对象的泛型类型实例化后为String，所以getElement方法只能接受String类型的List
        //java.lang.String
        System.out.println(genericTest.getElement(list).getClass().getTypeName());

        Test.NonGenericTest nonGenericTest = test.new NonGenericTest();
        //NonGenericTest类实例化后其getElement方法可以传入任意对象的List
        //java.lang.String
        System.out.println(nonGenericTest.getElement(list).getClass().getTypeName());
        //java.lang.Integer
        System.out.println(nonGenericTest.getElement(Collections.singletonList(1)).getClass().getTypeName());
    }
}
