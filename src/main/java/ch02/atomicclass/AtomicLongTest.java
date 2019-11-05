package ch02.atomicclass;

import java.util.concurrent.atomic.AtomicLong;

/***
 * Java中原子类AtomicLong
 */
public class AtomicLongTest {

    private static AtomicLong atomicLong = new AtomicLong();

    //创建数据源
    private static Integer [] arrayOne = new Integer[]{0,1,2,3,0,5,6,0,56,0};

    private static Integer[] arrayTwo = new Integer[]{10,1,2,3,0,5,6,0,56,0};

    public static void main(String... args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        Thread threadA = new Thread(() ->{
            int size = arrayOne.length;
            for(int i = 0;i < size;i ++){
                if(arrayOne[i].intValue() == 0){
                    atomicLong.incrementAndGet();
                }
            }
        });
        //线程A统计数组arrayOne中0的个数
//        Thread threadA = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int size = arrayOne.length;
//                for(int i = 0;i < size;i ++){
//                    if(arrayOne[i].intValue() == 0){
//                        atomicLong.incrementAndGet();
//                    }
//                }
//            }
//        });

//        Thread threadB = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int size = arrayTwo.length;
//                for(int i  = 0;i < size; i ++){
//                    if(arrayTwo[i].intValue() == 0){
//                        atomicLong.incrementAndGet();
//                    }
//                }
//            }
//        });

        Thread threadB = new Thread(()->{
            int size = arrayTwo.length;
            for(int i  = 0;i < size; i ++){
                if(arrayTwo[i].intValue() == 0){
                    atomicLong.incrementAndGet();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("count 0: " + atomicLong.get());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
