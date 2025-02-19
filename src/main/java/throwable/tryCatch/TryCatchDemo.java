package throwable.tryCatch;

/**
 * try里有return，并且执行到了，也会先把finally执行完再return。而不写finally则直接return，不往后执行。
 * catch里有return并且执行到了，同上。
 * try或catch里面有return并且执行到了，finally里面也有return，则最终是执行finally里面的return。
 * finally里面有return，finally体外也有return，对不起，语法不通过。
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.printf("%s", example1());
        System.out.printf("%n%n");
        System.out.printf("%s", example2());
        System.out.printf("%n%n");
        System.out.printf("%s", example3());
        System.out.printf("%n%n");
        System.out.printf("%s", example4());
        System.out.printf("%n%n");
        System.out.printf("%s", example5());
    }

    /**
     * return在try块中
     * <p>执行顺序：</p>
     * <p>执行 try 块中的代码，输出 "Inside try block"。</p>
     * <p>执行 try 块中的 return 10，但此时不会立即返回。</p>
     * <p>接着执行 finally 块中的代码，输出 "Inside finally block"。</p>
     * <p>最终返回值 10。</p>
     */
    public static int example1() {
        try {
            System.out.println("Inside try block");
            return 10; // return 语句
        } catch (Exception e) {
            System.out.println("Inside catch block");
        } finally {
            System.out.println("Inside finally block");
        }
        return 20; // 不会被执行
    }

    /**
     * return在catch块中
     * <p>执行顺序：</p>
     * <p>执行 try 块中的代码，输出 "Inside try block"。</p>
     * <p>抛出异常，进入 catch 块。</p>
     * <p>执行 catch 块中的代码，输出 "Inside catch block"。</p>
     * <p>执行 catch 块中的 return 20，但此时不会立即返回。</p>
     * <p>接着执行 finally 块中的代码，输出 "Inside finally block"。</p>
     * <p>最终返回值 20。</p>
     */
    public static int example2() {
        try {
            System.out.println("Inside try block");
            throw new Exception(); // 抛出异常
        } catch (Exception e) {
            System.out.println("Inside catch block");
            return 20; // return 语句
        } finally {
            System.out.println("Inside finally block");
        }
        //编译报错：java: 无法访问的语句
        //return 30;
    }

    /**
     * return同时在catch块和finally块中
     * <p>执行顺序：</p>
     * <p>执行 try 块中的代码，输出 "Inside try block"。</p>
     * <p>抛出异常，进入 catch 块。</p>
     * <p>执行 catch 块中的代码，输出 "Inside catch block"。</p>
     * <p>执行 finally 块中的代码，输出 "Inside finally block"。</p>
     * <p>执行 finally 块中的 return 30，覆盖 catch 块中的 return 20。</p>
     * <p>最终返回值 30。</p>
     */
    public static int example3() {
        try {
            System.out.println("Inside try block");
            throw new Exception(); // 抛出异常
        } catch (Exception e) {
            System.out.println("Inside catch block");
            return 20; // return 语句
        } finally {
            System.out.println("Inside finally block");
            return 30; // return 语句
        }
    }

    /**
     * 最佳实践：
     * <p>finally 块应仅用于资源清理（如关闭文件流、数据库连接等），而不应包含业务逻辑或 return 语句。</p>
     * <p>将 return 放置在 try 或 catch 块中</p>
     * <p>在大多数情况下，应将 return 语句放置在 try 或 catch 块中，而不是在 finally 块中。</p>
     * <p>finally 块可以包含一些清理逻辑，但不应影响程序的返回值。</p>
     */
    public static int example4() {
        int result = 0;

        try {
            System.out.println("Inside try block");
            throw new Exception(); // 抛出异常
        } catch (Exception e) {
            System.out.println("Inside catch block");
            result = 20; // 更新返回值
        } finally {
            System.out.println("Inside finally block");
            // 清理资源
        }

        return result; // 返回 20
    }

    /**
     * 最佳实践：
     * <p>如果 try 和 catch 块中都没有 return 语句，需要在方法末尾提供默认的返回值。</p>
     * <p>这可以确保方法在所有情况下都能返回一个值。</p>
     */
    public static int example5() {
        try {
            System.out.println("Inside try block");
        } catch (Exception e) {
            System.out.println("Inside catch block");
        } finally {
            System.out.println("Inside finally block");
        }

        return 0; // 默认返回值
    }
}
