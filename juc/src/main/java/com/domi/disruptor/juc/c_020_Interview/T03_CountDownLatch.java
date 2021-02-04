package com.domi.disruptor.juc.c_020_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Domi on 2021/01/21.
 */
public class T03_CountDownLatch {

    volatile List lists = new ArrayList();

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        T03_CountDownLatch c = new T03_CountDownLatch();
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        new Thread(()->{
            System.out.println("t2 开启");
            if (c.size() != 5){
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch2.countDown();
            }
            System.out.println("t2 结束");
        },"t2").start();

        new Thread(()->{
            System.out.println("t1 开始");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add "+i);
                if (c.size() == 5){
                    latch.countDown();
                    try {
                        latch2.await();
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
        },"t1").start();
    }
}
