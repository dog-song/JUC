package com.domi.disruptor.juc.c_001;

/**
 * Created by Domi on 2020/12/28.
 */
public class TT010 extends T010 {

    @Override
    synchronized void m(){

        System.out.println("child m start..");
        super.m();
        System.out.println("child m end..");
    }
}
