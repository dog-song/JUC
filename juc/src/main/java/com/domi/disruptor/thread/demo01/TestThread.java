package com.domi.disruptor.thread.demo01;


import java.util.ArrayList;
import java.util.List;

//集合不安全问题
public class TestThread {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }

            ).start();
        }

        System.out.println(list.size());

    }
}
