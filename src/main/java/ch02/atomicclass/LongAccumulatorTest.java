package ch02.atomicclass;

import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumulatorTest {

    //LongAccumulator是LongAdder的加强版，可以指定累加的初始值
    private static LongAccumulator longAccumulator = new LongAccumulator((x,y) -> x + y,0);

    //创建数据源
    private static Integer [] arrayOne = new Integer[]{0,1,2,3,0,5,6,0,56,0};

    private static Integer[] arrayTwo = new Integer[]{10,1,2,3,0,5,6,0,56,0};

    public static void main(String... args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            for(int i = 0; i < arrayOne.length;i ++){
                if(arrayOne[i] == 0){
                    longAccumulator.accumulate(1L);
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for(int i = 0;i < arrayTwo.length;i ++){
                if(arrayTwo[i] == 0){
                    longAccumulator.accumulate(1L);   //
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("count 0: " + longAccumulator.intValue());
    }

}
