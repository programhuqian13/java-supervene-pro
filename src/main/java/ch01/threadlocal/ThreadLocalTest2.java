package ch01.threadlocal;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.threadlocal
 */
public class ThreadLocalTest2 {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        //设置线程的变量
        threadLocal.set("hello world");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程输出线程变量的值
                System.out.println("thread:" + threadLocal.get());
            }
        });

        thread.start();

        //主线程输出线程的变量的值
        System.out.println("main:" + threadLocal.get());
    }

}
