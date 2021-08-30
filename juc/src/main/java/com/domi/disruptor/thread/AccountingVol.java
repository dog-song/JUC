package com.domi.disruptor.thread;

/**
 * @author domisong.
 * @description: volatile
 * @date 2021/3/31.
 */
public class AccountingVol implements Runnable{

    static AccountingVol instance = new AccountingVol();

    static volatile int i = 0;

    public static void increase () {
        i++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println(i);
    }
}
