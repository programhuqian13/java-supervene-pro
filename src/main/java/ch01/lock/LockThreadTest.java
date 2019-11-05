package ch01.lock;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/25
 * @ProjectName java-supervene-pro
 * @PackageName ch01
 */
public class LockThreadTest {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");
                    }
                    synchronized (resourceB) {
                        System.out.println("threadA get resourceB lock");
                        //线程A阻塞，并释放获取到的resourceA的锁
                        System.out.println("threadA release resourceA lock");
                        resourceA.wait();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    //获取resourceA共享资源的监视器锁
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA lock");
                        System.out.println("threadBtyr get  resourceB lock...");
                        //获取resourceB共享资源的监视器锁
                        synchronized (resourceB){
                            System.out.println("threadB get resourceB lock");
                            System.out.println("threadB release resourceA lock");
                            //线程B阻塞，并释放获取到的resourceA的锁
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();

        //等待两个线程结束
        threadA.join();
        threadB.join();
        System.out.println("main over");
    }
}
