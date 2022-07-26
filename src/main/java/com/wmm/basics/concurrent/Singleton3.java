package com.wmm.basics.concurrent;

public class Singleton3 {
    //私有化构造函数
    private Singleton3() {
    }

    //定义一个静态枚举类
    private enum SingletonEnum {
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private final Singleton3 singleton3;

        //私有化枚举的构造函数
        SingletonEnum() {
            singleton3 = new Singleton3();
        }

        private Singleton3 getInstnce() {
            return singleton3;
        }
    }

    //对外暴露一个获取User对象的静态方法
    public static Singleton3 getInstance() {
        return SingletonEnum.INSTANCE.getInstnce();
    }
}
