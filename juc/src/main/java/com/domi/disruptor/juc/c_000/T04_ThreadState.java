package com.domi.disruptor.juc.c_000;

/**
 * Created by Domi on 2020/12/24.
 */
public class T04_ThreadState {

    public static void main(String[] args) {
        Thread thread = new Thread();

        System.out.println(thread.getState());

        thread.start();
        System.out.println(thread.getState());
        try{
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
}
