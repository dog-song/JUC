package com.domi.disruptor.juc.c_001;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Domi on 2020/10/29.
 *
 *  比较synchronized、AtomicXXX、LongAdder哪个效率更高
 *
 *  结论：
 *      在这种的情况下，synchronized < AtomicXXX < LongAdder
 */
public class AtomicVsSyncVsLongAdder {

    static long count2 = 0L;
    static AtomicLong count1 = new AtomicLong(0L);
    static LongAdder count3 = new LongAdder();


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];

        //--------------------------------------------------------------------
        for (int i = 0; i < threads.length; i++) {
            threads[i] =
                    new Thread(()->{
                        for (int j = 0; j < 100000; j++) {
                            count1.incrementAndGet();
                        }
                    });
        }

        long start = System.currentTimeMillis();
        for (Thread t:threads) t.start();
        for (Thread t:threads) t.join();
        long end = System.currentTimeMillis();

//        TimeUnit.SECONDS.sleep(10);
        System.out.println("Atomic :"+count1.get()+" ,TIME :"+(end-start));

        //--------------------------------------------------------------------
        Object lock = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] =
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int k=0;k<100000;k++)
                                synchronized(lock){
                                count2++;
                                }
                        }
                    });
        }
        start = System.currentTimeMillis();
        for (Thread t:threads) t.start();
        for (Thread t:threads) t.join();
        end = System.currentTimeMillis();
        System.out.println("Sync :" + count2+" TIME:"+(end-start));
        //--------------------------------------------------------------------
        for (int i = 0; i < threads.length; i++) {
            threads[i] =
                    new Thread(()->{
                        for (int k=0;k<100000;k++) count3.increment();
                    });
        }
        start = System.currentTimeMillis();
        for (Thread t:threads) t.start();
        for (Thread t:threads) t.join();
        end = System.currentTimeMillis();
        System.out.println("LongAdder :" + count3+" TIME:"+(end-start));

    }

    static void microSleep(int m){
        try {
            TimeUnit.MICROSECONDS.sleep(m);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
