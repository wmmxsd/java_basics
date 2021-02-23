package exception;

/**
 * RuntimeException类异常不用捕获，非RuntimeException类异常需要捕获
 * @author wangmingming160328
 * @date @2021/2/22 17:08
 */
public class NerverCaught {
    void method1() {
        throw new RuntimeException("exception in method1");
    }

    void method2() {
        method1();
    }

    void method3() throws Exception {
        throw new Exception("exception in method3");
    }

    void method4() throws Exception {
        method3();
    }

    public static void main(String[] args) {
        NerverCaught nerverCaught = new NerverCaught();
        try {
            nerverCaught.method2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            nerverCaught.method4();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
