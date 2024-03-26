package Thread;

import java.util.concurrent.*;

/**
 * @author: quanli
 * @description: TODO
 * @date: 2024/3/26 15:40
 * @version: 1.0
 */
public class ThreadPoolExecutorExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 记录开始执行的时间
        long startTime = System.currentTimeMillis();

        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
                {26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35},
                {36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45},
                {46, 47, 48, 49, 50}
        };

        // 创建一个固定大小的线程池
        int nThreads = 5; // 线程池中线程的数量
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        // 提交任务给线程池处理，并收集 Future 对象
        Future<Integer>[] futures = new Future[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            int[] array = arrays[i];
            futures[i] = executor.submit(() -> {
                int sum = 0;
                for (int num : array) {
                    sum += num;
                }
                return sum;
            });
        }

        // 等待所有任务执行完毕，并收集结果
        int[] results = new int[arrays.length];
        for (int i = 0; i < futures.length; i++) {
            results[i] = futures[i].get();
            System.out.println("Sum of array " + (i + 1) + ": " + results[i]);
        }

        // 关闭线程池
        executor.shutdown();

        // 记录结束执行的时间
        long endTime = System.currentTimeMillis();

        // 计算执行总耗时
        long totalTime = endTime - startTime;
        System.out.println("Total execution time: " + totalTime + " milliseconds");
    }
}
