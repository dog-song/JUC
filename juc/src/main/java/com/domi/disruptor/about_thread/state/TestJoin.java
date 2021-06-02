package com.domi.disruptor.about_thread.state;


//线程强制执行
public class TestJoin implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();


        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i==80){
                //强制执行
                thread.join();
            }
            System.out.println("我是主线程:"+i);
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我是要插队的线程:"+i);
        }
    }
}

/*
Blocked
New
Run
Terminated : 终止
wait():等待


 */