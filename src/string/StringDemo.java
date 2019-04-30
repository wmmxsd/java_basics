package string;

public class StringDemo {
    public static void main(String[] args) {
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        String s32 = s3.intern();
        System.out.println(s3 == s4);


        String c = new String("2");
        c.intern();

        String a = "2";
        System.out.println(a == c);
    }
}
