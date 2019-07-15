package main.java.com.wmm.basics.AnonymousInnerClass;

public class test {
    public static void main(String[] args) {
        //匿名内部类用于抽象类
        Person person = new Person() {
            @Override
            public void eat() {
                System.out.println("大朗吃药了");
            }
        };
        person.eat();

        //匿名内部类用于接口
        People people = () -> System.out.println("大朗请坐");
        people.sit();

        Thread thread = new Thread(){
            /**
             * If this thread was constructed using a separate
             * <code>Runnable</code> run object, then that
             * <code>Runnable</code> object's <code>run</code> method is called;
             * otherwise, this method does nothing and returns.
             * <p>
             * Subclasses of <code>Thread</code> should override this method.
             *
             * @see #start()
             * @see #stop()
             */
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(i + " ");
                }
            }
        };
        thread.run();
    }
}
