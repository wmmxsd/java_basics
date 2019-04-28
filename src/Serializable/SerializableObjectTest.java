package Serializable;

import java.io.*;

public class SerializableObjectTest {
    public static void main(String[] args) throws Exception
    {
        File file = new File("D:" + File.separator + "s.txt");
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(new SerializableObject("str0", "str1"));
        oos.close();

        InputStream is = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(is);
        SerializableObject so = (SerializableObject)ois.readObject();
        System.out.println("str0 = " + so.getStr0());
        System.out.println("str1 = " + so.getStr1());
        ois.close();
    }
}
