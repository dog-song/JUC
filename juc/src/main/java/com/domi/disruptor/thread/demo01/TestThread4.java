package com.domi.disruptor.thread.demo01;


//初识并发问题：多个线程同时操作一个对象（runnable接口实现类）
//线程不安全
public class TestThread4 implements Runnable {

    //票
    private int ticketNums = 10;

    @Override
    public void run() {
        test();
    }


    public void test(){
        //执行体
        while (true){
            if (ticketNums<=0){
                break;
            }
            //模拟网络延时，睡眠
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //获取线程名字
            System.out.println(Thread.currentThread().getName()+"-->抢到了第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 t = new TestThread4();

        //第二个参数，创建线程名字
        new Thread(t,"小明").start();
        new Thread(t,"老师").start();
        new Thread(t,"黄牛党").start();
    }

}
