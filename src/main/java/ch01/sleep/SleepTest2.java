package ch01.sleep;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.sleep
 */
public class SleepTest2 {

    public static void main(String... args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("child thread is in sleep");
                    Thread.sleep(10000);
                    System.out.println("child thread is in awaked");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        //启动线程
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

}
