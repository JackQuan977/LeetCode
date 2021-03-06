package Thread.ConsumerAndProducter;

import java.util.ArrayList;
import java.util.List;

public class ProducerCustomerModel {
    static int MAX_SIZE = 10;
    static List<Integer> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        new Thread(new Producer()).start();
        new Thread(new Customer()).start();
    }

    private static class Producer implements Runnable{
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(250); // 生产效率：每250ms一个
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (list){
                    // 第一步：拿到锁
                    while(list.size() >= MAX_SIZE) {
                        // 第二步，判断能不能生产。
                        // 如果发现库存满了，就进入等待池，放弃锁，线程暂停。
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 如果有，生产一个
                    list.add(1);
                    System.out.println("生产了一个产品，现在有"+list.size()+"个产品。");
                    // 唤醒消费线程，可以试图消费了。
                    list.notifyAll();
                }
            }
        }
    }

    private static class Customer implements Runnable{
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(250); // 消费效率：每500ms一个
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (list){
                    // 第一步：拿到锁
                    while(list.size()==0){
                        // 第二步，判断能不能消费。
                        // 如果发现没有商品了，就进入等待池，放弃锁，线程暂停。
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 如果有，消费一个
                    list.remove(0);
                    System.out.println("消费了一个产品，现在有"+list.size()+"个产品。");
                    // 唤醒生产线程，可以试图生产了。
                    list.notifyAll();
                }
            }
        }
    }
}
