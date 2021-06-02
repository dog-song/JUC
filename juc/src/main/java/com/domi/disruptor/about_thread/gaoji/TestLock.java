package com.domi.disruptor.about_thread.gaoji;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();

        new Thread(helloWorld).start();
        new Thread(helloWorld).start();

    }
}


class HelloWorld implements Runnable{

    int ticketNums = 100;
    //可重入锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){

            try {
                lock.lock(); //加锁
                //判断是否有票
                if (ticketNums>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            } finally {
                lock.unlock();//解锁
            }

        }

    }

}