package com.domi.disruptor.about_thread.syn;

import java.util.concurrent.CopyOnWriteArrayList;

public class SafeJUCList {
    public static void main(String[] args) throws InterruptedException {
        //保证线程安全的list , ArrayList
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                    list.add(Thread.currentThread().getName());
            }).start();
        }

        for (int i = 5;i>0;i--){
            Thread.sleep(1000);
            System.out.println("倒计时"+i);
        }

        System.out.println(list.size());
    }
}
