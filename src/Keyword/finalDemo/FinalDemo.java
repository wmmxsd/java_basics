package Keyword.finalDemo;

public class FinalDemo {
    public static final String LOAN = "loan";

    public static void main(String[] args) {
        //Error:(7, 9) java: 无法为最终变量LOAN分配值
        //LOAN = new String("loan");
    }
}
