package Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        // 创建一个CyclicBarrier实例，指定等待的线程数量为3
        CyclicBarrier barrier = new CyclicBarrier(3, new BarrierAction());

        // 创建三个线程，分别执行不同的任务
        Thread worker1 = new Thread(new Worker3(barrier, "Task 1"));
        Thread worker2 = new Thread(new Worker3(barrier, "Task 2"));
        Thread worker3 = new Thread(new Worker3(barrier, "Task 3"));

        // 启动三个线程
        worker1.start();
        worker2.start();
        worker3.start();
    }
}

class Worker3 implements Runnable {
    private final CyclicBarrier barrier;
    private final String taskName;

    public Worker3(CyclicBarrier barrier, String taskName) {
        this.barrier = barrier;
        this.taskName = taskName;
    }

    @Override
    public void run() {
        // 模拟任务执行
        System.out.println(taskName + " is executing.");
        try {
            Thread.sleep(2000); // 模拟任务耗时
            System.out.println(taskName + " has completed its work and waiting at the barrier.");
            // 等待其他线程到达栅栏点
            barrier.await();
            System.out.println(taskName + " continues its work after the barrier.");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class BarrierAction implements Runnable {
    @Override
    public void run() {
        // 所有线程都到达栅栏点时执行的动作
        System.out.println("Barrier action: All threads have reached the barrier.");
    }
}
