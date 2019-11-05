package ch01.notify;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/25
 * @ProjectName java-supervene-pro
 * @PackageName ch01
 */
public class NotifyAndNotifyAllTest {

    private static volatile Object resourceA = new Object();

    public static void main(String... args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取resourceA共享资源的监视器锁
                synchronized (resourceA){
                    System.out.println("threadA get resourceA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();  //挂载线程
                        System.out.println("threadA end wait");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadB get resourceA lock");
                    try{
                        System.out.println("threadB begin wait");
                        resourceA.wait();

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadC get resourceA lock");
                    resourceA.notify();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();
        //等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");
    }

}
