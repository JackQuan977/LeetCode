package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockThread implements Runnable{
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < 3; i++){
                System.out.println(Thread.currentThread().getName() + "输出了" + i);
            }
        }finally {
            lock.unlock();
        }

    }
}
