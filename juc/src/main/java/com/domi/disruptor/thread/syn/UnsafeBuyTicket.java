package com.domi.disruptor.thread.syn;

//线程同步问题一 :线程不安全,买票问题
public class UnsafeBuyTicket implements Runnable {

    //票数
    private int ticketNums = 10;
    //标志位
    private boolean flag = true;


    @Override
    public void run() {
        //买票
        while (flag) {
            buyTicket();
        }
    }

    public void buyTicket() {
        // 判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }

        //模拟网络延时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "张票");
    }


    public static void main(String[] args) {
        UnsafeBuyTicket station = new UnsafeBuyTicket();

        new Thread(station,"苦逼的我").start();
        new Thread(station,"牛逼的你们").start();
        new Thread(station,"可恶的黄牛党").start();

    }

}



