package ch01.threadlocal;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/26
 * @ProjectName java-supervene-pro
 * @PackageName ch01.threadlocal
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> localVariable = new ThreadLocal<String>();

    static void print(String str){
        System.out.println(str + ":" + localVariable.get());
        //清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程A中本地变量localVariable的值
                localVariable.set("threadA local variable");
                print("threadA");
                //打印本地变量
                System.out.println("threadA remove after " + ":" + localVariable.get());
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程B的本地变量
                localVariable.set("threadB local variable");
                print("threadB");
                System.out.println("threadB remove after " + ":" + localVariable.get());
            }
        });

        threadA.start();
        threadB.start();

    }



}
