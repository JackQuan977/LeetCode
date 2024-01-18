package Thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        // 创建一个CountDownLatch实例，计数值为3
        CountDownLatch latch = new CountDownLatch(3);

        // 创建三个线程，分别执行不同的任务
        Thread worker1 = new Thread(new Worker2(latch, "Task 1"));
        Thread worker2 = new Thread(new Worker2(latch, "Task 2"));
        Thread worker3 = new Thread(new Worker2(latch, "Task 3"));

        // 启动三个线程
        worker1.start();
        worker2.start();
        worker3.start();

        try {
            // 主线程等待所有任务完成
            latch.await();
            System.out.println("All tasks have been completed. Main thread continues.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Worker2 implements Runnable {
    private final CountDownLatch latch;
    private final String taskName;

    public Worker2(CountDownLatch latch, String taskName) {
        this.latch = latch;
        this.taskName = taskName;
    }

    @Override
    public void run() {
        // 模拟任务执行
        System.out.println(taskName + " is executing.");
        try {
            Thread.sleep(2000); // 模拟任务耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 任务执行完毕，计数器减一
        System.out.println(taskName + " has completed.");
        latch.countDown();
    }
}
