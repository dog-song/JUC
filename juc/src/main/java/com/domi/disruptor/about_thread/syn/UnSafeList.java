package com.domi.disruptor.about_thread.syn;

import java.util.ArrayList;
import java.util.List;


//线程不安全问题3,集合操作
//思考?怎么让这些问题变安全.
public class UnSafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 20000; i++) {
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
