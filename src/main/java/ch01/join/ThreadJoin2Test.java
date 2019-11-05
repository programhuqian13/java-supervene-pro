package ch01.join;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/25
 * @ProjectName java-supervene-pro
 * @PackageName ch01
 */
public class ThreadJoin2Test {

    public static void main(String... args) throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadA begin run!");
                for (;;){

                }
            }
        });

        //获取主线程
        final Thread mainThread = Thread.currentThread();

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //中断主线程
                mainThread.interrupt();
            }
        });

        threadA.start();
        threadB.start();
        try {
            threadA.join();
        }catch (InterruptedException e){
            System.out.println("Main thread:" + e);
        }
    }

}
