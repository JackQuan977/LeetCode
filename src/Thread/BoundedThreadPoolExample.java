package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class BoundedThreadPoolExample {
    public static void main(String[] args) {
        // 定义有界队列大小
        int queueSize = 5;

        // 创建有界队列
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(queueSize);

        // 创建有界线程池，最大线程数为3
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3, // 核心线程数
                3, // 最大线程数
                0, // 空闲线程等待新任务的超时时间
                java.util.concurrent.TimeUnit.MILLISECONDS, // 时间单位
                queue // 任务队列
        );

        // 提交一系列任务给线程池
        for (int i = 0; i < 8; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing task: " + taskId);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskId + " completed");
            });
        }

        // 关闭线程池
        executor.shutdown();
    }
}
