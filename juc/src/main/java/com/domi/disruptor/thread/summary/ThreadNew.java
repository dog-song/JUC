package com.domi.disruptor.thread.summary;

//线程创建方式
/*
1.继承Thread
2.实现Runnable接口
3.实现Callable接口
4.使用线程池
 */


import java.util.concurrent.*;

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1");
    }
}


class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread2");
    }
}

class MyThread3 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("MyThread3");
        return 200;
    }
}


public class ThreadNew {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new MyThread1().start();

        new Thread(new MyThread2()).start();

        FutureTask<Integer> future = new FutureTask<Integer>(new MyThread3());
        new Thread(future).start();


        Integer integer = future.get();
        System.out.println(integer);

    }


}
