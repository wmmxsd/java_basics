package com.wmm.basics.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmingming160328
 * @Description 源码研究
 * @date @2019/7/16 17:31
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("1", "2");
    }
}
