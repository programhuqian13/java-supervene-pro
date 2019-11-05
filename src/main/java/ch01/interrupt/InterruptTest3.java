package ch01.interrupt;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.interrupt
 */
public class InterruptTest3 {

    public static void main(String... args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){

                }
            }
        });

        threadA.start();
        threadA.interrupt();  //设置中断标志
        //获取中断标志
        System.out.println("isInterrupted:" + threadA.isInterrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted:" + threadA.interrupted()); //这里获取的主线程的中断状态

        //获取中断标志并重置
        System.out.println("isInterrupted:" + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted:" + threadA.isInterrupted());
        threadA.join();
        System.out.println("main thread is over");

    }

}
