package com.wmm.basics.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 通过集合和数组相互转换及集合的reverse()方法反转数组
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/10/11 16:22
 */
public class CollectionToArrayDemo {
    public static void main(String[] args) {
        String [] s= new String[]{"dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"};
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        //没有指定类型的话会报错
        String[] strArr =list.toArray(new String[0]);
    }
}
