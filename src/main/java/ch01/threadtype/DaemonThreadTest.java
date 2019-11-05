package ch01.threadtype;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.threadtype
 */
public class DaemonThreadTest {

    //创建一个守护进程
    public static void main(String[] args) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){

                }
            }
        });
        //设置为守护进程
        daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println("main is over");
    }
}
