package ch03;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest2 {

    public static void main(String... args) throws InterruptedException {
        Thread thread  = new Thread(() -> {
            System.out.println("child thread begin park!");
            while(!Thread.currentThread().isInterrupted()){
                LockSupport.park();
            }
            System.out.println("child thread begin unpark");
        });

        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread begin unpark");
        thread.interrupt();  //中断子线程
    }

}
