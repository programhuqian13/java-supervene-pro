package ch03;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

public class LockSupportUnParkTest {

    public static void main(String... args){
        System.out.println("begin park!");
        //当一个线程调用unpark方法，如果参数thread线程没有持有thread与LockSupport类关联的许可证
        //则让thread线程持有，如果thread之前因调用park而被挂起，则调用unpark后，该线程会被唤醒
        //如果thread之前没有调用park，则会立即返回。


        //使当前线程获取到许可证
        LockSupport.unpark(Thread.currentThread());
        //再次调用park方法
        LockSupport.park();
        System.out.println("end park!");

    }

}
