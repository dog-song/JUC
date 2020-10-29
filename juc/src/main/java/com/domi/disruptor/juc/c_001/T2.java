package com.domi.disruptor.juc.c_001;

import java.sql.Time;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Domi on 2020/10/12.
 */
public class T2 {
    /**
     *  脏读问题：
     *  dirtyRead
     **/

    String name;
    double balance;

    public synchronized void set(String name ,double balance){
        this.name = name;
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized*/ double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {

        int[] intstr = {1,2,3,4,5,6,7,8,9,10};
        String[] str = new String[intstr.length];
        for(int i=0; i<intstr.length; i++){
            str[i] = String.valueOf(intstr[i]);
        }
        System.out.println(str);
        int positon = Arrays.binarySearch(str, "6");
        System.out.println("str is:"+positon);


        T2 t = new T2();

        new Thread(()->t.set("zhangsan" ,100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getBalance("zhangsan"));
    }
}
