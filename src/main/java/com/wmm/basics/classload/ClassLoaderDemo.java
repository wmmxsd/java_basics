package com.wmm.basics.classload;

/**
 * @author wangmingming160328
 * @Description 类加载器实例
 * @date @2020/4/13 17:56
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("ClassLoader.getSystemClassLoader():" + ClassLoader.getSystemClassLoader());
        System.out.println("ClassLoaderDemo.class.getClassLoader():" + ClassLoaderDemo.class.getClassLoader());
        System.out.println("ClassLoaderDemo.class.getClassLoader().getParent():" + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("ClassLoaderDemo.class.getClassLoader().getParent().getParent():" + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
        System.out.println("AppClassLoader的父类加载器为ExtClassLoader ExtClassLoader的父类加载器为null，null并不代表ExtClassLoader没有父类加载器，而是 BootstrapClassLoader 。");
    }
}
