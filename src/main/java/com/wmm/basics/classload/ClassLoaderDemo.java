package com.wmm.basics.classload;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author wangmingming160328
 * @Description 类加载器实例
 * @date @2020/4/13 17:56
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        System.out.println("ClassLoader.getSystemClassLoader():" + ClassLoader.getSystemClassLoader());
        System.out.println("ClassLoaderDemo.class.getClassLoader():" + ClassLoaderDemo.class.getClassLoader());
        System.out.println("ClassLoaderDemo.class.getClassLoader().getParent():" + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("ClassLoaderDemo.class.getClassLoader().getParent().getParent():" + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
        System.out.println("AppClassLoader的父类加载器为ExtClassLoader ExtClassLoader的父类加载器为null，null并不代表ExtClassLoader没有父类加载器，而是 BootstrapClassLoader 。");
        Class<String> stringClass = (Class<String>) ClassLoader.getSystemClassLoader().loadClass(String.class.getName());
        Class<String> stringClass1 = (Class<String>) ClassLoader.getSystemClassLoader().loadClass(String.class.getName());
        System.out.println(stringClass == stringClass1);

        //带上/表示类的绝对路径，会将类加载器的路径加上
        System.out.println("ClassLoaderDemo.class.getResource(\"/\").getPath() = "
                                   + ClassLoaderDemo.class.getResource("/").getPath());

        //不带上/表示相对路径，会自动加上类的绝对路径
        System.out.println("ClassLoaderDemo.class.getResource(\"\").getPath() = "
                                   + ClassLoaderDemo.class.getResource("").getPath());


        System.out.println("ClassLoaderDemo.class.getResource(\"ClassLoaderDemo.class\").getPath() = "
                                   + ClassLoaderDemo.class.getResource("ClassLoaderDemo.class").getPath());

        //注意：ClassLoader#getResource()不能以/开头
        System.out.println("ClassLoaderDemo.class.getClassLoader().getResource(\"\").getPath() = "
                                   + ClassLoaderDemo.class.getClassLoader().getResource("").getPath());

        System.out.println("ClassLoaderDemo.class.getClassLoader().getResource(\"com/wmm/basics/classload/ClassLoaderDemo.class\").getPath() = "
                                   + ClassLoaderDemo.class.getClassLoader().getResource("com/wmm/basics/classload/ClassLoaderDemo.class").getPath());

        InputStream inputStream = ClassLoaderDemo.class.getClassLoader().getResourceAsStream("java/lang/String.class");
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            byte[] bytes = new byte[4];
            bufferedInputStream.read(bytes);
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw e;
        }
    }
}
