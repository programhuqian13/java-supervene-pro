package ch01.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.sleep
 */
public class SleepTest {

    //创建一个独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String... args){

        Thread threadA = new Thread(()->{
//            @Override
//            public void run() {
                lock.lock(); //获取独占锁
            try {
                System.out.println("child threadA is in sleep");
                Thread.sleep(10000);
                System.out.println("child threadA is in awaked");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();  //释放锁
            }

//            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();

                try {
                    System.out.println("child threadB is in sleep");
                    Thread.sleep(10000);
                    System.out.println("child threadB is in awaked");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        });

        //启动线程
        threadA.start();
        threadB.start();
    }


}
