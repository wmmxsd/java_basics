package Collections;

import java.util.*;

public class HashMapDemo1 {
    public static void main(String[] args) {
        testHashMapAPIs();
    }
    public static void testHashMapAPIs(){
        Random random = new Random();
        HashMap map = new HashMap();
        //put
        map.put("one", random.nextInt(10));
        map.put("two", random.nextInt(10));
        map.put("three", random.nextInt(10));

        System.out.println("map:"+map);
        map.equals(2);
        for (Iterator iterator = map.keySet().iterator();iterator.hasNext();){
            String key = (String) iterator.next();
            System.out.println("key:"+key);
        }

        for (Iterator iterator = map.entrySet().iterator();iterator.hasNext();){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        map.containsKey("two");
        map.containsValue(10);
        map.put(null,2);
        map.put(5,5);
        map.put(6,6);
        map.put(7,7);
        map.put(8,8);
        map.put(9,9);
        map.put(10,10);
        map.put(5,10);
        map.put(12,12);
        map.put(13,13);
        map.containsValue(10);
        for (int i = 0; i < 30; ++i){
            map.put(i,i);
        }
        map.remove(20);
        //清空map(节点为Null，size为0)
        map.clear();
    }
}
