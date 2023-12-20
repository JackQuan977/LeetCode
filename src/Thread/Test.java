package Thread;

import java.io.IOException;
import java.util.Vector;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // 启动线程1

        MyThread t2 = new MyThread();
        t2.start(); // 启动线程2
    }
}
