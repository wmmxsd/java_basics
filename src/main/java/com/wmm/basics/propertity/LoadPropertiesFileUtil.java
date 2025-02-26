package com.wmm.basics.propertity;

import java.io.*;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class LoadPropertiesFileUtil {
    //private static String basePath = "/src/main/resources/log4j.properties";
    private static String basePath = "src/main/resources/log4j.properties";
    private static String path = "";

    /**
     * 一、 使用java.util.Properties类的load(InputStream in)方法加载properties文件
     *
     * @return
     */
    public static String getPath1() {
        /*String basePath1 = "/log4j.properties";
        String basePath2 = "/src/main/resources/log4j.properties";
        String basePath3 = "src/main/resources/log4j.properties";

        if (new File(basePath1).exists()) {
            System.out.println(basePath1);
        } else if (new File(basePath2).exists()) {
            System.out.println(basePath2);
        } else if (new File(basePath3).exists()) {
            System.out.println(basePath3);
        }*/

        try {
            InputStream in = new BufferedInputStream(new FileInputStream(
                    basePath));
            Properties prop = new Properties();

            prop.load(in);

            path = prop.getProperty("log4j.rootLogger");

        } catch (FileNotFoundException e) {
            System.out.println("properties文件路径书写有误，请检查！");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    /**
     * 二、 使用java.util.ResourceBundle类的getBundle()方法
     * 注意：这个getBundle()方法的参数只能写成包路径+properties文件名，否则将抛异常
     *
     * @return
     */
    public static String getPath2() {
        ResourceBundle rb = ResourceBundle
                .getBundle("log4j");
        path = rb.getString("log4j.rootLogger");
        return path;
    }

    /**
     * 三、 使用java.util.PropertyResourceBundle类的构造函数
     *
     * @return
     */
    public static String getPath3() {
        InputStream in;
        try {
            in = new BufferedInputStream(new FileInputStream(basePath));
            ResourceBundle rb = new PropertyResourceBundle(in);
            path = rb.getString("log4j.rootLogger");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 四、 使用class变量的getResourceAsStream()方法
     * 注意：getResourceAsStream()方法的参数按格式写到包路径+properties文件名+.后缀
     *
     * @return
     */
    public static String getPath4() {
        InputStream in = LoadPropertiesFileUtil.class
                .getResourceAsStream("/log4j.properties");
        Properties p = new Properties();
        try {
            p.load(in);
            path = p.getProperty("log4j.rootLogger");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 五、
     * 使用class.getClassLoader()所得到的java.lang.ClassLoader的
     * getResourceAsStream()方法
     * getResourceAsStream(name)方法的参数必须是包路径+文件名+.后缀
     * 否则会报空指针异常
     * @return
     */
    public static String getPath5() {
        InputStream in = LoadPropertiesFileUtil.class.getClassLoader()
                .getResourceAsStream("log4j.properties");
        Properties p = new Properties();
        try {
            p.load(in);
            path = p.getProperty("log4j.rootLogger");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 六、 使用java.lang.ClassLoader类的getSystemResourceAsStream()静态方法
     * getSystemResourceAsStream()方法的参数格式也是有固定要求的
     *
     * @return
     */
    public static String getPath6() {
        InputStream in = ClassLoader
                .getSystemResourceAsStream("log4j.properties");
        Properties p = new Properties();
        try {
            p.load(in);
            path = p.getProperty("log4j.rootLogger");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 一个properties对象能够加载多个配置文件。若不同文件包含相同的配置项，那么以最后加载的那个配置项为准。
     */
    public static void getPath7() {
        InputStream inputStream1 = ClassLoader.getSystemResourceAsStream("ftpdir.conf");
        InputStream inputStream2 = ClassLoader.getSystemResourceAsStream("log4j.properties");

        Properties properties = new Properties();
        try {
            properties.load(inputStream2);
            properties.load(inputStream1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(properties.getProperty("log4j.rootLogger"));
        System.out.println(properties.getProperty("ftpUrl"));
        System.out.println(properties.getProperty("log4j.logger.org.springframework"));
    }

    public static void main(String[] args) {
        System.out.println(LoadPropertiesFileUtil.getPath1());
        System.out.println(LoadPropertiesFileUtil.getPath2());
        System.out.println(LoadPropertiesFileUtil.getPath3());
        System.out.println(LoadPropertiesFileUtil.getPath4());
        System.out.println(LoadPropertiesFileUtil.getPath5());
        System.out.println(LoadPropertiesFileUtil.getPath6());
        getPath7();
    }
}
