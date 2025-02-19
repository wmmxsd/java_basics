# 异常类

## Throwable类

Java 中的所有异常类都继承自 Throwable 类。Throwable 类有两个主要的子类：

- Error：表示严重的错误，通常是 JVM 或系统级别的问题，程序无法处理（如
  OutOfMemoryError、StackOverflowError、NoClassDefFoundError、NoSuchMethodError）。
- Exception：表示可以被捕获和处理的异常。
    - Checked Exception：受检异常，编译器强制要求处理的异常，必须捕获或声明抛出（如 IOException、SQLException）。
    - Unchecked Exception：非受检异常，运行时异常或错误，不强制处理（如NullPointerException、ArrayIndexOutOfBoundsException）。

### Error类

Error类的实例由Java虚拟机生成并抛出，程序中通常不对这类错误进行处理。

```java
public class StackOverflowErrorExample {
    public static void main(String[] args) {
        recursiveMethod(); // 无限递归调用
    }

    private static void recursiveMethod() {
        recursiveMethod(); // 递归调用，没有终止条件
    }
}
```

上面的代码运行后会报“StackOverflowError”,该报错就是由jvm生成并抛出。

### Exception类

#### Checked Exception 受检异常

编译时检查的异常，必须进行处理（如 IOException、SQLException）。这类异常是可预见的，并且可以通过适当的处理逻辑来避免或解决。

例如，在读取文件时可能会遇到FileNotFoundException，如果不处理则编译时会提示“java: 未报告的异常错误java.io.FileNotFoundException;
必须对其进行捕获或声明以便抛出”。

```java
public class FileNotFoundExceptionExample {
    public static void main(String[] args) {
        FileInputStream file = new FileInputStream("test.txt");
    }
}
```

例如，在加载类时可能会遇到ClassNotFoundException，如果不处理则编译时会提示“java: 未报告的异常错误java.lang.ClassNotFoundException;
必须对其进行捕获或声明以便抛出”。

```java
public class ClassNotFoundExceptionExample {
    public static void main(String[] args) {
        try {
            Class.forName("com.example.NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("类未找到: " + e.getMessage());
        }
    }
}
```

#### Unchecked Exception：非受检异常

这类异常是不可预见的，通常是因为程序中的某些逻辑错误导致的。虽然它们不是强制要求处理的，但良好的编程实践建议尽量避免这些异常的发生。

例如下面代码中可能发生非受检的异常

```java
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
```







