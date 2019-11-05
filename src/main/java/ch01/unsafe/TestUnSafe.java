package ch01.unsafe;

import sun.misc.Unsafe;

public class TestUnSafe {

    //获取unsafe的实例
    static final Unsafe UNSAFE = Unsafe.getUnsafe();  //这里会直接抛出一个安全异常

    //记录变量state在类中的偏移值
    static final long STATE_OFFSET;

    private volatile long state = 0L;

    static{
        try {
            //使用objectFieldOffset获取state的变量
            //在TestUnSafe类里面的内存偏移量地址并将其保存到STATE_OFFSET
            STATE_OFFSET = UNSAFE.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String... args){
        TestUnSafe testUnSafe = new TestUnSafe();

        Boolean success = UNSAFE.compareAndSwapInt(testUnSafe,STATE_OFFSET,0,1);
        System.out.println(success);
        System.out.println("this is a testUnsafe");
    }


}
