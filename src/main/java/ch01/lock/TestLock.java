package ch01.lock;

public class TestLock {

    public synchronized void helloA(){
        System.out.println("hello");
    }

    public synchronized void helloB(){
        System.out.println("Hello B");
        helloA();
    }

    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        testLock.helloB();
    }

}
