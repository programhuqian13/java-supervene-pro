package ch01.join;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/25
 * @ProjectName java-supervene-pro
 * @PackageName ch01
 */
public class ThreadJoinTest {

    public static void main(String... args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadOne over!");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadTwo over!");
            }
        });

        //启动子线程
        threadOne.start();
        threadTwo.start();
        System.out.println("wait all child thread over!");
        //等待子进程执行完毕，返回
        threadOne.join();
        threadTwo.join();

        System.out.println("all child thread over！");
    }

}
