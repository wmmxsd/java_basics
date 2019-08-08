package com.wmm.basics;

public enum Day2 {
    LONG("long", "com.sys.common.base.enum.sysconfigtype.long"),
    INT("int", "com.sys.common.base.enum.sysconfigtype.int"),
   DOUBLE("double", "com.sys.common.base.enum.sysconfigtype.double"),
    FLOAT("float", "com.sys.common.base.enum.sysconfigtype.float"),
     STRING("main/java/com/wmm/basics/string", "com.sys.common.base.enum.sysconfigtype.main.java.com.wmm.basics.string"),
    BOOLEAN("boolean", "com.sys.common.base.enum.sysconfigtype.boolean");

    private String type;
    private String desc;//中文描述

    /**
     * 私有构造,防止被外部调用
     *
     * @param type
     * @param desc
     */
    Day2(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    /**
     * 覆盖
     *
     * @return
     */
    @Override
    public String toString() {
        return desc;
    }



    public static void main(String[] args) {
        for (Day2 day : Day2.values()) {
            System.out.println("name:" + day.name() + ",type:" + day.type+ ",desc:" + day.toString());
        }
    }
}
