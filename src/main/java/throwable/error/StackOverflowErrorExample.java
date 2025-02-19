package throwable.error;

/**
 *  Error：表示严重的错误，通常是 JVM 或系统级别的问题，程序无法处理（如 OutOfMemoryError、StackOverflowError、NoClassDefFoundError、NoSuchMethodError）。
 *  执行下面的main方法会报“Exception in thread "main" java.lang.StackOverflowError”错误
 */
public class StackOverflowErrorExample {
    public static void main(String[] args) {
        recursiveMethod(); // 无限递归调用
    }

    private static void recursiveMethod() {
        recursiveMethod(); // 递归调用，没有终止条件
    }
}
