package throwable.exception.uncheckedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UncheckedExceptionExample {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length()); // 抛出 NullPointerException

        int[] arr = {1, 2, 3};
        System.out.println(arr[3]); // 抛出 ArrayIndexOutOfBoundsException

        int result = 10 / 0; // 抛出 ArithmeticException

        Object obj = "Hello";
        Integer num = (Integer) obj; // 抛出 ClassCastException

        String str1 = "abc";
        int num1 = Integer.parseInt(str1); // 抛出 NumberFormatException
        setAge(-1);

        List<Integer> list = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
        list.add(4); // 抛出 UnsupportedOperationException

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        for (Integer numTemp : list1) {
            list.remove(numTemp); // 抛出 ConcurrentModificationException
        }

        MyClass myClass = new MyClass();
        myClass.doSomething();
    }

    private static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("年龄不能为负数");
        }
    }

    public static class MyClass {
        private boolean initialized = false;

        public void doSomething() {
            if (!initialized) {
                throw new IllegalStateException("对象未初始化");
            }
        }
    }
}
