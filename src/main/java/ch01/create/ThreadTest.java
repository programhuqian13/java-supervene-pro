package ch01.create;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/24
 * @ProjectName java-supervene-pro
 * @PackageName ch01
 */
public class ThreadTest {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("这是使用继承Thread创建线程！");
        }
    }

    public static void main(String... args){
        //创建线程
        //创建一个MyThread的实例，该线程并没有被启动执行，直到调用了start方法之后才是真正的启动了线程
        //调用start方法后并没有马上执行而是处于就绪状态，等待CPU分配资源，当CPU分配资源之后才会真正处于运行状态
        //只要run方法执行完毕之后该线程就处于终止状态。
        MyThread myThread = new MyThread();
        //启动线程
        myThread.start();
    }

}
