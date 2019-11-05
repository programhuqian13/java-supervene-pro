package ch03;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/***
 *CopyOnWriteArrayList是一个线程安全的ArrayList
 * CopyOnWriteArrayList的弱一致性：弱一致性是指返回迭代器后，其他线程对list的增删改对迭代器是不可见的。
 */
public class CopyOnWriteArrayListTest {

    public static void main(String... args){
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("tony");
        copyOnWriteArrayList.add("hello world");
        Iterator<String> iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
