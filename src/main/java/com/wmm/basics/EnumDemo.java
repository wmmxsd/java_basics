package com.wmm.basics;

public class EnumDemo {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        Day[] days = new Day[]{Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY, Day.SUNDAY};
        int count = 0;
        for (Day day : days) {
            System.out.println("day[" + count + "].ordinal()=" + day.ordinal());
            count++;
        }

        System.out.println("-------------------------------------");
        //通过compareTo方法比较,实际上其内部是通过ordinal()值比较的
        System.out.println("days[0].compareTo(days[1]):" + days[0].compareTo(days[1]));
        System.out.println("days[0].compareTo(days[2]):" + days[0].compareTo(days[2]));

        //获取该枚举对象的Class对象引用,当然也可以通过getClass方法
        Class<?> clazz = days[0].getDeclaringClass();
        System.out.println("clazz:" + clazz);
        Class clazz1 = days[0].getClass();
        System.out.println("clazz1:" + clazz1);
        System.out.println("-------------------------------------");
        //name()
        System.out.println("days[0].name():" + days[0].name());
        System.out.println("days[1].name():" + days[1].name());
        System.out.println("days[2].name():" + days[2].name());
        System.out.println("days[3].name():" + days[3].name());

        System.out.println("-------------------------------------");

        System.out.println("days[0].toString():" + days[0]);
        System.out.println("days[1].toString():" + days[1]);
        System.out.println("days[2].toString():" + days[2]);
        System.out.println("days[3].toString():" + days[3]);

        System.out.println("-------------------------------------");

        Day d = Enum.valueOf(Day.class, days[0].name());
        Day d2 = Day.valueOf(Day.class, days[0].name());
        System.out.println("d:" + d);
        System.out.println("d2:" + d2);
    }
}
