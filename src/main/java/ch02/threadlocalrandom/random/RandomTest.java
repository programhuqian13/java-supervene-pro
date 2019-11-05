package ch02.threadlocalrandom.random;

import java.util.Random;

public class RandomTest {

    public static void main(String... args){
        //创建一个默认的随机生成器
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            System.out.println(random.nextInt(5));
        }
    }

}
