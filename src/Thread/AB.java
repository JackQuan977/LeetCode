package Thread;

public class AB {
    private static boolean flag = false;
    public static void main(String[] args) {
        Object LOCK = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (LOCK) {
                        while (flag) {
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + "-------" + "A");
                        flag = true;
                        LOCK.notify();
                    }
                }
            }
        }, "线程1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (LOCK) {
                        while (!flag) {
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + "-------" + "B");
                        flag = false;
                        LOCK.notify();
                    }
                }
            }
        }, "线程2");

        t1.start();
        t2.start();
    }
}
