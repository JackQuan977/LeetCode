package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // 创建 Callable 对象
        MyCallable myCallable = new MyCallable();

        // 提交 Callable 任务给线程池
        Future<String> future = executorService.submit(myCallable);

        try {
            // 获取 Callable 任务的执行结果
            String result = future.get();
            System.out.println("Callable result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭线程池
        executorService.shutdown();
    }
}

// 实现 Callable 接口的任务
class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // 执行一些耗时的任务，并返回结果
        return "Hello from Callable!";
    }
}
