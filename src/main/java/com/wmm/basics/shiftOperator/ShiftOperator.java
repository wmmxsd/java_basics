package main.java.com.wmm.basics.shiftOperator;

public class ShiftOperator {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(num);
        printToConsole(num);
        //左移一位
        num = num << 1;
        System.out.println(num);
        printToConsole(num);
        //左移一位
        num = num << 1;
        System.out.println(num);
        printToConsole(num);
        num = num >> 2;
        System.out.println(num);
        printToConsole(num);
    }

    /**
     * 输出一个二进制数
     * @param out
     */
    private static void printToConsole(int out){
        System.out.println(Integer.toBinaryString(out));
    }
}
