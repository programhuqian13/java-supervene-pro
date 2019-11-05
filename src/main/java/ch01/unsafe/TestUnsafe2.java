package ch01.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe2 {

    static final Unsafe unsafe;
    static final long stateOffset;
    private volatile long state = 0L;

    static{
        try {
            //使用反射获取unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可存取
            field.setAccessible(true);
            //获取该变量的值
            unsafe = (Unsafe) field.get(null);
            //获取state在TestUnsafe2中的偏移量
            stateOffset = unsafe.objectFieldOffset(TestUnsafe2.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        } catch (IllegalAccessException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String... args){
        TestUnsafe2 testUnsafe2 = new TestUnsafe2();
        Boolean bool = unsafe.compareAndSwapInt(testUnsafe2,stateOffset,0,1);
        System.out.println(bool);
    }

}
