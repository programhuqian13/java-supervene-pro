package jvm;

/**
 * @Description 虚拟机栈stackOverflowException异常测试
 * @Version 1.0
 * @Date 2019/11/5
 * @ProjectName java-supervene-pro
 * @PackageName jvm
 * vm参数： -Xss128k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    private void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    public static void main(String... args) throws Throwable{
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e){
            System.out.println("stack Length: " + javaVMStackSOF.stackLength);
            throw e;
        }
    }

    /***
     * 实验证明：在单线程下，无论是由于栈帧太大还是虚拟机栈容量太小，当内存无法分配的时候，
     * 虚拟机会抛出StackOverFlowExeption异常
     */




}
