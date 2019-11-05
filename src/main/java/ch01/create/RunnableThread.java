package ch01.create;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/24
 * @ProjectName java-supervene-pro
 * @PackageName ch01
 */
public class RunnableThread {

    public static class RunnableTask implements Runnable{

        @Override
        public void run() {
            System.out.println("这是实现Runable接口的形式！");
        }
    }

    public static void main(String... args) {
        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();
    }

}
