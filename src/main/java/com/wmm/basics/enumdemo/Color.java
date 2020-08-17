package com.wmm.basics.enumdemo;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/7/10 0:09
 */
enum Color {
    /**
     * 红色
     */
    RED(1, "#1223"),
    /**
     * 蓝色
     */
    BLUE(2, "#3213");

    private int code;
    private String number;

    Color(int code, String number) {
        this.code = code;
        this.number = number;
    }

    public static void main(String[] args) {
        for (Color color : Color.values()) {
            System.out.println(color);
        }
        System.out.println("************");

        for (Color color : Color.values()) {
            System.out.println(color.name() + ";" + color.ordinal() + ";");
        }

        Color color = Color.valueOf("RED");
    }

}


