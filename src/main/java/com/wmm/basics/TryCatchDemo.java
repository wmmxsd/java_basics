package com.wmm.basics;

/**
 *
 * try里有return，并且执行到了，也会先把finally执行完再return。而不写finally则直接return，不往后执行。
 * catch里有return并且执行到了，同上。
 * try或catch里面有return并且执行到了，finally里面也有return，则最终是执行finally里面的return。
 * finally里面有return，finally体外也有return，对不起，语法不通过。
 * @author wangmingming160328
 * @Description tryCatchDemo
 * @date @2020/5/6 11:19
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            try {
                if (i == 2) {
                    throw new Exception();
                }
                if (i== 1) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }finally {
                System.out.println(i);
            }
        }
    }
}
