package com.domi.disruptor.thread.state;


//测试守护线程
//用户线程: 虚拟机要等待用户线程执行完毕
//守护线程: 虚拟机 不用等待 守护线程 执行完毕
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        Thread thread = new Thread(god);
        thread.setDaemon(true); //设置线程为守护线程,默认为false
        thread.start();

        //用户线程
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                System.out.println("你开心的在这个世界上活着"+i);
            }
            System.out.println("=======Goodbye , World!");
        }).start();
    }
}

//守护线程
class God implements Runnable{
    @Override
    public void run() {
        for (;true;){
            System.out.println("上帝保佑着你");
        }
    }
}