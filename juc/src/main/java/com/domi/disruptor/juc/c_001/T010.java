package com.domi.disruptor.juc.c_001;

import java.util.concurrent.TimeUnit;

/**
 * Created by Domi on 2020/12/28.
 */
public class T010 {
    synchronized void m(){
        System.out.println(" m Start ..");

        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" m end..");
    }

    public static void main(String[] args) {
        new TT010().m();
    }
}
