package com.wmm.basics.innerclass.nested;

/**
 * 嵌套类(静态内部类)和普通内部类的区别
 * @author wangmingming160328
 * @date @2021/1/5 11:36
 */
public class Good {
    private static String company;
    private int size;
    int weight;

    public class Logistics {
        //Inner classes cannot have static declarations
        //private static String from = "武汉";

        private String from = company;

        public String now() {
            return getCompany();
        }

        //Inner classes cannot have static declarations
        //public static String log() {}
    }

    public static class GoodUtils {
        //Non-static field 'size' cannot be referenced from a static context
        //private String size1 = size;

        private String name = "utils";
        private static String version = "1.1";

        public String getName() {
            System.out.println(company);
            System.out.println(getCompany());
            return name;
        }

        public static String getVersion() {
            return version;
        }
    }

    public static String getCompany() {
        return company;
    }
}
