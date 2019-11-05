package ch01.interrupt;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.interrupt
 */
public class InterruptTest4 {

    public static void main(String... args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //中断标志为true时会退出循环，并且清除中断标志
                while(Thread.currentThread().interrupted()){
                    System.out.println("threadA isInterrupted:" + Thread.currentThread().isInterrupted());
                }
            }
        });

        threadA.start();
        threadA.interrupt();
        threadA.join();
        System.out.println("main is over");
    }

}
