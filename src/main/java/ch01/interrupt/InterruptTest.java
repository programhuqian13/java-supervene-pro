package ch01.interrupt;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.interrupt
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //如果当前线程被中断退出循环
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread() + "hello");
                }
            }
        });

        thread.start();
        Thread.sleep(1000);
        System.out.println("Main thread interrupt thread");
        thread.interrupt();
        thread.join();
        System.out.println("main is over");
    }

}
