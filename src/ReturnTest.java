public class ReturnTest {
    public static void main(String[] args) {
        check(false);
        System.out.println("return后继续执行main()");
    }

    private static void check(Boolean element){
        if (!element){
            return;
        }
    }
}
