package com.wmm.basics.string;

/**
 * 直接使用双引号声明出来的 String 对象会直接存储在常量池中。
 * 如果不是用双引号声明的 String 对象，可以使用 String 提供的 intern 方法。
 * String.intern() 是一个 Native(本地方法，和硬件相关) 方法，
 * 它的作用是：如果运行时常量池中已经包含一个等于此 String 对象内容的字符串，则返回常量池中该字符串的引用；
 * 如果没有，则在常量池中创建与此 String 内容相同的字符串，并返回常量池中创建的字符串的引用。
 */
public class StringDemo3 {
    public static void main(String[] args) {
        //先检查字符串常量池中有没有"abcd"，如果字符串常量池中没有，则创建一个，然后str1指向字符串常量池中的对象，如果有，则直接将str1指向"abcd""；
        String str1 = "abcd";
        //先检查字符串常量池中有没有"abcd"，如果字符串常量池中没有，则创建一个，然后str1指向字符串常量池中的对象，如果有，则直接将str1指向"abcd""；
        String str2 = "abcd";
        //堆中创建一个新的对象
        String str3 = new String("abcd");
        //堆中创建一个新的对象
        String str4 = new String("abcd");
        //true
        System.out.println(str1 == str2);
        //false
        System.out.println(str3 == str4);
        //false
        System.out.println(str1 == str3);
        //false
        System.out.println(str2 == str3);

        str3 = str3.intern();
        //true
        System.out.println(str1 == str3);

        String str5 = str1 + str2;
        String str6 = str3 + str4;
        String str7 = "abcd" + "abcd";
        String str8 = "abcdabcd";
        //false （因为str5是两个变量相加得到的，而只要有一个变量在运算表达式中存在，计算结果就是变量，存储在堆中，str6也是，所以是两个不同的对象，为false）
        System.out.println(str5 == str6);
        //false（str7是2个常量相加得到的，所以他是存储在常量池中，str5存储在堆中，故为false）
        System.out.println(str5 == str7);
        //true（str8是常量的，所以他是存储在常量池中，str7存储在常量池中，故为true）
        System.out.println(str7 == str8);
    }
}
