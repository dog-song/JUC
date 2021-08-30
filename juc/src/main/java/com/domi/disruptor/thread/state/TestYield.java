package com.domi.disruptor.thread.state;

//线程的礼让
public class TestYield {

    public static void main(String[] args) throws InterruptedException {

        MyYield myYield = new MyYield();
        new Thread(myYield,"小明").start();
        new Thread(myYield,"老师").start();



    }

}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->启动了");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"-->停止了");
    }
}