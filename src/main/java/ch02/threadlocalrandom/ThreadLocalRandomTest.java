package ch02.threadlocalrandom;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {

    public static void main(String... args){
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();   //获取当前线程的随机数生成器
        for(int i = 0;i < 10; ++i){
            System.out.println(localRandom.nextInt(5));
        }
    }

}
