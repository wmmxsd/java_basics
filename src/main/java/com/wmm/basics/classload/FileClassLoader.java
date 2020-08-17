package com.wmm.basics.classload;

import java.io.*;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/8/18 0:28
 */
public class FileClassLoader extends ClassLoader{
    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = getClassData(name);
        if (bytes == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, bytes, 0, bytes.length);
        }

    }

    //编写读取字节流的方法
    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String rootDir="D:\\TECHNOLOGY\\CODE\\idea_workspace\\java_basics\\target\\classes";
        //创建自定义文件类加载器
        FileClassLoader loader = new FileClassLoader(rootDir);
        FileClassLoader loader1 = new FileClassLoader(rootDir);

        try {
            //加载指定的class文件
            Class<?> object1=loader.loadClass("com.wmm.basics.classload.Demo");
            Class<?> object2=loader.loadClass("com.wmm.basics.classload.Demo");
            Class<?> object3=loader1.loadClass("com.wmm.basics.classload.Demo");
            //true
            System.out.println(object1 == object2);
            //true
            System.out.println(object1 == object3);
            System.out.println(object1.newInstance().toString());
            Class<?> object5=loader.findClass("com.wmm.basics.classload.Demo");
            //attempted  duplicate class definition for name: "com/wmm/basics/classload/Demo"
            //Class<?> object6=loader.findClass("com.wmm.basics.classload.Demo");
            Class<?> object7=loader1.findClass("com.wmm.basics.classload.Demo");
            //false
            System.out.println(loader == loader1);
            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
