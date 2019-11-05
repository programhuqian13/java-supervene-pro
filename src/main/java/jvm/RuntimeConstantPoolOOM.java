package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 运行时常量池导致的内存溢出
 * @Version 1.0
 * @Date 2019/11/5
 * @ProjectName java-supervene-pro
 * @PackageName jvm
 *
 * vm参数：-XX：PermSize=10M -XX:MaxPermSize=10M
 *
 * 在java设计中，1.7的版本开始逐步去永久代的事情。 在jdk 1.6会抛出异常
 * 说明在1.6的jdk版本中运行时常量池属于方法区的一部分
 * 在1.7之后while会一直运行下去。
 *
 */
public class RuntimeConstantPoolOOM {

    public static void main(String... args){
        //使用list保持常量池引用，避免Full GC回收常量池的行为
        List<String> list = new ArrayList<>();
        int i = 0;
        /***
         * String.intern()是一个native方法，作用是：
         * 如果字符串常量池中国包含一个等于此String对象的字符串，则返回代表池中这个字符串
         * 的String对象，否则，将此String对象包含的字符串添加到常量池中，并且返回此String
         * 对象的引用
         *
         */
        while(true){
            list.add(String.valueOf(i + 1).intern());
        }
    }

}
