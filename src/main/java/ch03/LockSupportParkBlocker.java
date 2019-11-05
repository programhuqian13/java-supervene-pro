package ch03;


import java.util.concurrent.locks.LockSupport;

public class LockSupportParkBlocker {

    public void testPark(){
//        LockSupport.park();  //当使用这个方法的时候，会阻塞，我们不知道具体阻塞在哪里，我们可以使用另一个方法进行观察
        LockSupport.park(this);  //这里可以看到具体的阻塞原因
    }

    public static void main(String... args){
        LockSupportParkBlocker lockSupportParkBlocker = new LockSupportParkBlocker();
        lockSupportParkBlocker.testPark();
    }

}
