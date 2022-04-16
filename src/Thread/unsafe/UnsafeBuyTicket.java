package Thread.unsafe;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"小明").start();
        new Thread(buyTicket,"黄牛1").start();
        new Thread(buyTicket,"黄牛2").start();
    }
}
