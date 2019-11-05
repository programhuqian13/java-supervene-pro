package ch03;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.LockSupport;

public class CopyOnWriteArrayListTest2 {

    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    /**
     * 主线程在子线程执行完毕后使用获取的迭代器遍历数组元素，从输出结果我们知道
     * 在子线程里面进行的操作一个都没有生效，这就体现了弱一致性。
     * 需要注意：获取迭代器的操作必须在子线程操作之前完成
     * @param args
     * @throws InterruptedException
     */
    public static void main(String... args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("shanghai");
        arrayList.add("this is a city");
        arrayList.add("from");
        arrayList.add("china");
        Thread thread = new Thread(() -> {
            arrayList.set(1,"haha");
            arrayList.remove(2);
            arrayList.remove(3);
        });

        Iterator<String> iterator = arrayList.iterator();

        thread.start();
        thread.join();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
