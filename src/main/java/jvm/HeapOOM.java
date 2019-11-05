package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Java堆内存溢出异常测试
 * @Version 1.0
 * @Date 2019/11/5
 * @ProjectName java-supervene-pro
 * @PackageName jvm
 * vm 参数：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * HeapDumpOnOutOfMemoryError：可以让虚拟机在出现内存溢出异常是Dump出当前的内存堆
 * 转储快照以便事后进行分析
 */
public class HeapOOM {

    static class OOMObject{

    }

    /**
     * 会产生内存溢出异常
     * java.lang.OutOfMemoryError: Java heap space
     Dumping heap to java_pid16816.hprof ...
     Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     at java.util.Arrays.copyOf(Arrays.java:3210)
     at java.util.Arrays.copyOf(Arrays.java:3181)
     at java.util.ArrayList.grow(ArrayList.java:261)
     at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
     at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
     at java.util.ArrayList.add(ArrayList.java:458)
     at jvm.HeapOOM.main(HeapOOM.java:24)
     Heap dump file created [28246240 bytes in 0.120 secs]
     * @param args
     */
    public static void main(String... args){
        List<OOMObject> list = new ArrayList<>();

        while(true){
            list.add(new OOMObject());
        }
    }

}
