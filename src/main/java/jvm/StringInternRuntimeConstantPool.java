package jvm;

/**
 * @Description String.intern()的测试常量池
 * @Version 1.0
 * @Date 2019/11/5
 * @ProjectName java-supervene-pro
 * @PackageName jvm
 */
public class StringInternRuntimeConstantPool {

    public static void main(String... args){
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        /***
         * 运行结果：
         *  在1.6的版本中返回2个false
         *      intern()方法会把首次遇到的字符串实例复制到永久代中，返回的也是永久代中这个字符串
         *      实例的引用，而StringBuilder创建的字符串实例在Java堆上，所以不是一样的。
         *  在1.7的版本中返回一个true和一个false
         *      intern()实现不会再复制实例，只是在常量池中记录首次出现的实例引用，只是在常量池
         *      中记录首次出现的实例引用，因此intern()返回的引用和由StringBuilder创建的那个
         *      字符串实例是同一个。对str2返回false是因为“java”这个字符串在执行StringBuilder
         *      .toString()之前已经出现过，字符串常量池中已经有它的引用了，不符合首次出现。
         *
         */

    }

}
