package com.domi.disruptor.thread.syn;

public class SafeBuyTicket implements Runnable {

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

    //同步方法,关键词synchroinzed.

    //关键字是锁
    //实现的机制是队列

    //还能所反射的那个class

    public synchronized void buyTicket() {
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
        SafeBuyTicket station = new SafeBuyTicket();

        new Thread(station,"苦逼的我").start();
        new Thread(station,"牛逼的你们").start();
        new Thread(station,"可恶的黄牛党").start();

    }
}
