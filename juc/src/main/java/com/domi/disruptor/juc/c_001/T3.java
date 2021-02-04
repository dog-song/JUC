package com.domi.disruptor.juc.c_001;

/**
 * Created by Domi on 2020/12/14.
 */
public class T3 {

    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        for (String s : ary) {
            System.out.println(s);
        }
        System.out.println("---------------");
        System.out.println(ary.length);
    }
}
