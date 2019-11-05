package jvm;

/**
 * @Description 虚拟机栈在多线程下抛出OutOfMemoryException
 * @Version 1.0
 * @Author xuanyi@baofu.com
 * @Date 2019/11/5
 * @ProjectName java-supervene-pro
 * @PackageName jvm
 * vm参数：-Xss4M
 *
 * 如果是简历过多线程导致的内存溢出，在不能减少线程数或更换64位虚拟机的情况下
 * 就只能通过减少最大堆和减少栈容量来换取更多的线程
 *
 * 提示：如果直接运行下面的代码，在window平台的虚拟机中，Java的线程是映射到
 * 操作系统的内核线程上，因此下面代码执行会有较大的风险，可能导致操作系统假死。
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }

    public void stackLeckThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String... args){
        JavaVMStackOOM stackOOM = new JavaVMStackOOM();
        stackOOM.stackLeckThread();
    }

}
