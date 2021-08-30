package com.domi.disruptor.thread.summary;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//使用线程池
public class ThreadPool{

    public static void main(String[] args) {

        //创建一个线程池(池子大小)
        ExecutorService pool = Executors.newFixedThreadPool(10);

        //执行runnable接口实现类
        pool.execute(new MyThread4());
        pool.execute(new MyThread4());
        pool.execute(new MyThread4());
        pool.execute(new MyThread4());

        //关闭连接池
        pool.shutdown();

    }

}

class MyThread4 implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread4");
    }
}