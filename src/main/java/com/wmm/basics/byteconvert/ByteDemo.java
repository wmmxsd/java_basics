package com.wmm.basics.byteconvert;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/9/11 14:32
 */
public class ByteDemo {
    public static void main(String[] args) {
        String hex =  Integer.toHexString(60001);
        System.out.println(hex);
        String binary = Integer.toBinaryString(60001);

        byte[] bytes = hex2Byte(hex);

        int count = 2 * 8;
        System.out.println(count);
        System.out.println(2 << 3);
    }

    private static byte[] hex2Byte(String hexString) {
        String hexStr = "0123456789ABCDEF";
        //hexString的长度对2取整，作为bytes的长度
        int len = hexString.length() / 2;
        byte[] bytes = new byte[len];
        //字节高四位
        byte high = 0;
        //字节低四位
        byte low = 0;
        for (int i = 0; i < len; i++) {
            //右移四位得到高位
            high = (byte) ((hexStr.indexOf(hexString.charAt(2 * i))) << 4);
            low = (byte) hexStr.indexOf(hexString.charAt(2 * i + 1));
            //高地位做或运算
            bytes[i] = (byte) (high | low);
        }
        return bytes;
    }

    //高位在前，低位在后
    public static byte[] int2bytes(int num) {
        byte[] result = new byte[4];
        result[0] = (byte) ((num >>> 24) & 0xff);
        result[1] = (byte) ((num >>> 16) & 0xff);
        result[2] = (byte) ((num >>> 8) & 0xff);
        result[3] = (byte) ((num >>> 0) & 0xff);
        return result;
    }
}
