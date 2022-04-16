package Thread.WaitAndNotify;

public class Test {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();

        SynNotifyMethodThread c = new SynNotifyMethodThread(lock);
        c.start();
    }
}
