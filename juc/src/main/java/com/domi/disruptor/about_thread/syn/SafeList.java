package com.domi.disruptor.about_thread.syn;

import java.util.ArrayList;
import java.util.List;

//JUC并发编程 , 保证线程安全的一些类.
public class SafeList {
    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        for (int i = 5;i>0;i--){
            Thread.sleep(1000);
            System.out.println("倒计时"+i);
        }

        System.out.println(list.size());

    }
}
