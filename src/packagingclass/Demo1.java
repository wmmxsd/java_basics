package packagingclass;

/**
 * 八种基本类型
 * byte,short,int,long,double,float,boolean,char
 */
public class Demo1 {
    public static void main(String[] args) {
        Integer i1 = 33;
        Integer i2 = 33;
        System.out.println(i1 == i2);// 输出true  从缓存数组中取值
        Integer i11 = 333;
        Integer i22 = 333;
        System.out.println(i11 == i22);// 输出false new Integer(int i)
        Double i3 = 1.2;
        Double i4 = 1.2;
        System.out.println(i3 == i4);// 输出false

        Integer i5 = 12;
        Integer i6 = 12;
        Integer i7 = new Integer(12);
        System.out.println(i5 == i6);// 输出true
        System.out.println(i5 == i7);// 输出false
        i7 = i6.intValue();
        System.out.println(i5 == i6);// 输出true
    }
}
