package Thread.unsafe;

public class BuyTicket implements Runnable{
    //票
    private int ticket = 10;
    private boolean flag = true;//线程停止标志

    @Override
    public void run() {
        try{
            //买票
            while (flag){
                buy();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if(ticket<=0){
            flag = false;
            return;
        }
        //模拟延迟
        Thread.sleep(500);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticket--);
    }
}
