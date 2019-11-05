package ch01.lock;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.lock
 */
public class DeadLockTest2 {

    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("threadA wait resourceB");
                    synchronized (resourceB){
                        System.out.println("threadA get resourceB");
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //将资源的顺序和线程A一样将可以避免死锁
                synchronized (resourceA) {
                    System.out.println("threadB get resourceB");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("threadB wait resourceA");
                    synchronized (resourceB){
                        System.out.println("threadB get resourceA");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }

}
