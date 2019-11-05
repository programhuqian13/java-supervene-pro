package ch01.notify;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/25
 * @ProjectName java-supervene-pro
 * @PackageName ch01
 */
public class WaitNotifyInterupt {

    static Object obj = new Object();

    public static void main(String... args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("----begin---");
                    synchronized (obj) {
                        obj.wait();  //阻塞挂起自己
                    }
                    System.out.println("----end----");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        Thread.sleep(1000);
        System.out.println("----begin interrupt threadA----");
        threadA.interrupt();  //中断线程
        System.out.println("----end interrupt threadA----");
    }
}
