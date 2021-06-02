package com.domi.disruptor.about_thread.demo01;


import java.awt.*;

//线程创建方式一 ：
/*
第一步：继承Thread类
第二步：重写run（）方法
第三步：创建继承了Thread类的对象 ， 调用start（）方法启动。
 */
public class TestThread1 extends Thread{

    //自定义run方法的线程
    @Override
    public void run() {
        //线程执行体
        for (int i = 0; i < 200; i++) {
            System.out.println("有人在写笔记-->"+i);
        }
    }


    //主线程
    public static void main(String[] args) {

        //创建线程对象
        TestThread1 testThread1 = new TestThread1();
        //start（） 方法用来 启动线程；
        testThread1.start();

        for (int i = 0; i < 3000; i++) {
            System.out.println("有人在在睡觉sleep-->"+i);
        }

    }

}
