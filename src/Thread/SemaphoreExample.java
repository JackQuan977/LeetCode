package Thread;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        // 创建一个Semaphore实例，设置许可数量为3
        Semaphore semaphore = new Semaphore(3);

        // 模拟10个线程需要访问共享资源
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(new Worker(semaphore, i));
            thread.start();
        }
    }
}

class Worker implements Runnable {
    private final Semaphore semaphore;
    private final int workerNumber;

    public Worker(Semaphore semaphore, int workerNumber) {
        this.semaphore = semaphore;
        this.workerNumber = workerNumber;
    }

    @Override
    public void run() {
        try {
            System.out.println("Worker " + workerNumber + " is waiting to acquire permit.");

            // 获取许可
            semaphore.acquire();

            System.out.println("Worker " + workerNumber + " has acquired permit.");

            // 模拟工作
            Thread.sleep(2000);

            System.out.println("Worker " + workerNumber + " is releasing permit.");

            // 释放许可
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
