package packagingclass;

public class AutoLoadingAndUnloading {
    public static void main(String[] args) {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2   " + (i1 == i2));//true
        System.out.println("i1=i2+i3   " + (i1 == i2 + i3));//true
        System.out.println("i1=i4   " + (i1 == i4));//false (i1为缓存中的对象，i4为新创建的对象，故不相等)
        System.out.println("i4=i5   " + (i4 == i5));//false
        ////因为+这个操作符不适用于Integer对象，首先i5和i6进行自动拆箱操作，进行数值相加，即i4 == 40。
        // 然后Integer对象无法与数值进行直接比较，所以i4自动拆箱转为int值40，最终这条语句转为40 == 40进行数值比较。
        System.out.println("i4=i5+i6   " + (i4 == i5 + i6));//true
        System.out.println("40=i5+i6   " + (40 == i5 + i6));//true
    }
}
