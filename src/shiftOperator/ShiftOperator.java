package shiftOperator;

public class ShiftOperator {
    public static void main(String[] args) {
        int num = 10;
        printToConsole(num);
        //左移一位
        num = num << 1;
        printToConsole(num);
        //左移一位
        num = num << 1;
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
