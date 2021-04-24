package com.domi.disruptor.about_thread;

/**
 * @author domisong.
 * @description: synchronized 作用于方法上，并与static连用，
 *              表示的是锁得是这个对象
 * @date 2021/3/31.
 */
public class AccountingSyncBad implements Runnable{

    static int i = 0;

    public static synchronized void increase () {
        i++;
    }


    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AccountingSyncBad());
        Thread t2 = new Thread(new AccountingSyncBad());

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println(i);
    }
}
