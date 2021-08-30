package com.domi.disruptor.thread.state;

//测试join方法
public class TestJoin2 {
    public static void main(String[] args) {
        new Teacher().start();
    }
}

class Teacher extends Thread{
    @Override
    public void run() {
        System.out.println("老师:小明,你留下来写作业");
        System.out.println("老师:放学别走,我们两谈一谈");
        Thread xm = new Thread(new XiaoMing());
        xm.start();
        //小明插队执行
        try {
            xm.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("老师:你可以走了");
    }
}

class XiaoMing implements Runnable{
    @Override
    public void run() {
        System.out.println("小明:好的老师,我写作业");
        for (int i = 10; i > 0 ; i--) {
            //模拟延时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("小明:正在写作业..."+i);
        }
        System.out.println("小明:老师我作业写完了");
    }
}