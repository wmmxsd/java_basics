package com.wmm.basics.collections;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Arrays.asList()方法使用注意事项：
 * 1.Arrays.asList()方法生成的List对象时Arrays类中的静态内部类，没有重写add()、remove()、clear()方法，调用AbstractList类中方法，直接抛出异常
 * 2.set方法只能设置数组已有的索引范围内的值，否则报错
 *3.因为Array.asList的形参是泛型可变参数，有泛型存在，所以必须得使用对象数据，若使用基本类型数据会导致实参变为一个参数，这个参数就是数据本身
 * @author wangmingming160328
 * @Description
 * @date @2019/10/11 14:35
 */
public class ArrayAsListDemo {
    public static void main(String[] args) {
        String[] ids = {"01", "02", "03"};
        List<String> strList = Arrays.asList(ids);
        System.out.println(strList.toString());
        System.out.println(strList.size());

        //Arrays.asList()方法生成的List对象时Arrays类中的静态内部类，没有重写add()、remove()、clear()方法，调用AbstractList类中方法，直接抛出异常
        //strList.add("04");

        strList.set(2, "04");
        System.out.println(strList.toString());
        //只能设置数组已有的索引范围内的值，否则报错
        //strList.set(4, "04");

        //因为Array.asList的形参是泛型可变参数，有泛型存在，所以必须得使用对象数据，若使用基本类型数据会导致实参变为一个参数，这个参数就是数据本身
        int[] myIntArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List myIntList = Arrays.asList(myIntArray);
        System.out.println(myIntList.size());
        System.out.println(myIntList.get(0));
        try {
            System.out.println(myIntList.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] intArray = (int[]) myIntList.get(0);
        System.out.println(Arrays.toString(intArray));

        List<String> stringList = new ArrayList<String>();
        CollectionUtils.addAll(stringList, ids);

        List<Integer> integerList = new ArrayList<Integer>();
        Integer[] integers = {1,2,3,4,5};
        CollectionUtils.addAll(integerList, integers);
    }
}
