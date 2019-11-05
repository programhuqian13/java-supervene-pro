package ch02.atomicclass;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {

    private static LongAdder longAdder = new LongAdder();

    //创建数据源
    private static Integer [] arrayOne = new Integer[]{0,1,2,3,0,5,6,0,56,0};

    private static Integer[] arrayTwo = new Integer[]{10,1,2,3,0,5,6,0,56,0};

    public static void main(String... args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        Thread threadA = new Thread(() -> {
            for(int i = 0;i < arrayOne.length;i++){
                if(arrayOne[i] == 0){
                    longAdder.increment();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for(int i = 0;i < arrayTwo.length;i++){
                if(arrayTwo[i] == 0){
                    longAdder.increment();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        System.out.println(String.format("count 0: %d",longAdder.intValue()));

        long endTIme = System.currentTimeMillis();

        System.out.println(endTIme - startTime);

    }

}
