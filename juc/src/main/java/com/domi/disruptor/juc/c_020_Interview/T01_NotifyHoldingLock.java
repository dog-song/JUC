package com.domi.disruptor.juc.c_020_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Domi on 2021/01/21.
 */
public class T01_NotifyHoldingLock {

    /*volatile*/ List lists = new ArrayList();

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        T01_NotifyHoldingLock t = new T01_NotifyHoldingLock();
        final Object lock = new Object();
        // t2 定义
        new Thread(()->{
            synchronized (lock){
                System.out.println("---t2 START---");
                if (t.size() != 5){
                    try{
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }

                System.out.println("---t2 END---");
            }

        },"t2").start();

        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        // t1 定义
        new Thread(()->{
            System.out.println("---t1 START---");
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    t.add(new Object());
                    System.out.println("add "+i);
                    if (t.size() == 5){
                        lock.notify();
                        try{
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    /*try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }

            }
        },"t1").start();
    }
}
