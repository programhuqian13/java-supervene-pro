package ch03;

import java.util.concurrent.locks.LockSupport;

public class LockSupportParkTest {

    /**
     * 运行结果：只会输出begin park，然后当前线程挂起，这是因为默认的情况下调用线程是不持有许可证的。
     * 因调用park方法而被阻塞的线程被其他线程中断而返回时并不会抛出InterruptedException
     * @param args
     */
    public static void main(String... args){
        System.out.println("begin park!");
        LockSupport.park();  //这个地方会被阻塞，但是不知道是什么原因，我们可以使用park的另外一个方法带Blocker的
        System.out.println("end park！");
    }

}
