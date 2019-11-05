package ch01.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/9/24
 * @ProjectName java-supervene-pro
 * @PackageName ch01
 */
public class FutureThread {

    public static class FutureCallerTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "hello world!";
        }
    }

    public static void main(String... args){
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<String>(new FutureCallerTask());
        //启动线程
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(String.format("这是使用FutureTask进行创建线程，返回值:%s",result));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
