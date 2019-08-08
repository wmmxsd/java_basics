package com.wmm.basics.network.serializable;

import java.io.*;

public class SerializableObjectTest {
    public static void main(String[] args) throws Exception
    {
        File file = new File("D:" + File.separator + "s.txt");
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        SerializableObject so = new SerializableObject(100, 200);
        System.out.println("原始对象:\r\n" + so);
        oos.writeObject(so);
        oos.close();

        InputStream is = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(is);
        SerializableObject so1 = (SerializableObject)ois.readObject();
        System.out.println("反序列化对象 :\n\r" + so1);
        ois.close();
        so1.setArea();
        System.out.println("设置area后的反序列化对象:\n" + so1);

    }
}
