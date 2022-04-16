package Thread;

public class FirstReentrantLock {
    public static void main(String[] args) {
        Runnable thrread = new ReentrantLockThread();
        new Thread(thrread,"a").start();
        new Thread(thrread,"b").start();
    }
}
