package ch01.threadlocal;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.threadlocal
 */
public class ThreadLocalTest3 {

    private static ThreadLocal<String> localVariable = new InheritableThreadLocal<String>();

    public static void main(String[] args) {
        localVariable.set("hello world");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread get mian thread local variable");
            }
        });

        thread.start();

        System.out.println("main thread get main local variable");

    }

}
