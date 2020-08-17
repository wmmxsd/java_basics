package com.wmm.basics.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description 泛型擦除
 * @date @2020/7/9 22:46
 */
public class GenericErasure {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);

        List<String> stringList = new ArrayList<>();
        stringList.add("2");

        //true(泛型擦除：Java在编译期间，所有的泛型信息都会被擦掉)
        System.out.println(integerList.getClass() == stringList.getClass());

        //integerList是List<Integer>类型，但是通过反射可以添加字符串，证实了泛型擦除，通过javap -c xxx.class文件得知，实例化的泛型类型都为转为Object对象
        integerList.getClass().getMethod("add", Object.class).invoke(integerList, "1");
        System.out.println(integerList.toString());
    }
}
