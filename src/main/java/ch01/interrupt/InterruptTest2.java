package ch01.interrupt;


/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.interrupt
 */
public class InterruptTest2 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("ThreadA begin sleep for 2000 seconds");
                    Thread.sleep(2000000);
                }catch (InterruptedException e){
                    System.out.println("threadA is interrupted while is sleeping");
                    return;
//                    e.printStackTrace();
                }
                System.out.println("threadA-leaving normally");
            }
        });

        threadA.start();;
        Thread.sleep(1000);
        threadA.interrupt();
        threadA.join();
        System.out.println("main thread is over");
    }

}
