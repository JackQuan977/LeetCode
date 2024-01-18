package Thread;

class MyThread extends Thread {
    private String threadName;
    private int delay;

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread-1", 1);
        MyThread thread2 = new MyThread("Thread-2", 2);

        // 启动线程
        thread1.start();
        thread2.start();

        try {
            // 等待线程结束
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread exiting.");
    }
    public MyThread(String name, int delay) {
        this.threadName = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println("Starting " + threadName);
        printTime();
        System.out.println("Exiting " + threadName);
    }

    private void printTime() {
        int count = 5;
        while (count > 0) {
            try {
                // 将秒转换为毫秒
                Thread.sleep(delay * 1000);
                System.out.println(threadName + ": " + java.time.LocalTime.now());
                count--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


