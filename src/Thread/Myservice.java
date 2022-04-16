package Thread;

        import java.util.concurrent.locks.Condition;
        import java.util.concurrent.locks.ReentrantLock;

public class Myservice {
    private ReentrantLock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "进入了awaitA方法");
            long timeBefore = System.currentTimeMillis();
            // 执行conditionA等待
            conditionA.await();
            long timeAfter = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"被唤醒");
            System.out.println(Thread.currentThread().getName() + "等待了: " + (timeAfter - timeBefore)/1000+"s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "进入了awaitB方法");
            long timeBefore = System.currentTimeMillis();
            // 执行conditionB等待
            conditionB.await();
            long timeAfter = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"被唤醒");
            System.out.println(Thread.currentThread().getName() + "等待了: " + (timeAfter - timeBefore)/1000+"s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signallA() {
        try {
            lock.lock();
            System.out.println("启动唤醒程序");
            // 唤醒所有注册conditionA的线程
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signallB() {
        try {
            lock.lock();
            System.out.println("启动唤醒程序");
            // 唤醒所有注册conditionB的线程
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
