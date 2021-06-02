package com.domi.disruptor.about_thread.demo01;

//创建线程方式2：实现runnable接口
//1.实现接口
//2.重写run方法

//3.创建runbale接口实现类的对象。
//启动线程。需要创建一个线程Thread对象 ， 然后把runbale接口实现类的对象丢到构造参数里 ， 调用start方式启动
public class TestThread3 implements Runnable {


    @Override
    public void run() {
        //线程执行体
        for (int i = 0; i < 200; i++) {
            System.out.println("有人在写笔记-->"+i);
        }
    }

    public static void main(String[] args) {
        //重点就是将runbale接口实现类的对象丢入Thread构造器
        TestThread3 testThread3 = new TestThread3();
        new Thread(testThread3).run();

        for (int i = 0; i < 3000; i++) {
            System.out.println("有人在在睡觉sleep-->"+i);
        }


    }


}
