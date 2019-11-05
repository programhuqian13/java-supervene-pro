package ch01.threadtype;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.threadtype
 */
public class UnDaemonThreadTest {

    public static void main(String[] args) {
        //创建非守护线程和前面一样
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){

                }
            }
        });

        thread.start();
        System.out.println("Main is over");
    }

}
