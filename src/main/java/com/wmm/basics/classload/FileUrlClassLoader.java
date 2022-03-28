package com.wmm.basics.classload;

import java.io.File;
import java.net.*;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/8/18 0:55
 */
public class FileUrlClassLoader extends URLClassLoader {

    public FileUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public FileUrlClassLoader(URL[] urls) {
        super(urls);
    }

    public FileUrlClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException, MalformedURLException {
        String rootDir="D:\\TECHNOLOGY\\CODE\\idea_workspace\\java_basics\\target\\classes\\com\\wmm\\basics\\classload";
        //创建自定义文件类加载器
        File file = new File(rootDir);
        //File to URI
        URI uri=file.toURI();
        URL[] urls={uri.toURL()};

        FileUrlClassLoader loader = new FileUrlClassLoader(urls);

        try {
            //加载指定的class文件
            Class<?> object1=loader.loadClass("com.wmm.basics.classload.Demo");
            System.out.println(object1.newInstance());

            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
