package com.domi.disruptor.thread.state;

//测试线程优先级
public class TestPriority {

    public static void main(String[] args) {
        // 主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());


        MyPriority myPriority = new MyPriority();
        Thread thread1 = new Thread(myPriority);
        Thread thread2 = new Thread(myPriority);
        Thread thread3 = new Thread(myPriority);
        Thread thread4 = new Thread(myPriority);
        Thread thread5 = new Thread(myPriority);


        // 先设置优先级，再启动
        thread1.setPriority(1);
        thread1.start();

        thread2.setPriority(4);
        thread2.start();

        thread3.setPriority(8);
        thread3.start();

        thread4.setPriority(9);
        thread4.start();

        thread5.setPriority(10);
        thread5.start();

    }



}


class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}