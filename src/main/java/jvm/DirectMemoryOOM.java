package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Description 本地直接内存溢出
 * @Version 1.0
 * @Date 2019/11/5
 * @ProjectName java-supervene-pro
 * @PackageName jvm
 * vm 参数： -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {

    private static final int  _1MB = 1024 * 1024;

    public static void main(String... args) throws IllegalAccessException, NoSuchFieldException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }

        /***
         * 这里会抛出java.lang.OutOfMemoryError
         * 由DirectMemory导致的内存溢出，在Heap Dump文件中不会看见明显的异常
         * MaxDirectMemorySize指定DirectMemory的容量，默认与java堆的最大值一样
         * unsafe.allocateMemory 这个是真正分配java内存的地方
         *
         */

    }

}
