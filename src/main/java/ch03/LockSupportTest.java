package ch03;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String... args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("child thread begin park!");
            //调用park方法挂起自己
            LockSupport.park();
            System.out.println("child thread unpark!");
        });
        //启动子线程
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread begin unpark!");
        //调用unpark方法让thread线程持有许可证，然后park方法返回
        LockSupport.unpark(thread);
    }

}
