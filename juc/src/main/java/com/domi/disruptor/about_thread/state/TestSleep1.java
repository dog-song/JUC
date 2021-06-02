package com.domi.disruptor.about_thread.state;



//sleep,模拟休眠 , 扩大问题的发生性.
public class TestSleep1 implements Runnable {

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

            //模拟延时
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
        TestSleep1 t = new TestSleep1();

        //第二个参数，创建线程名字
        new Thread(t,"小明").start();
        new Thread(t,"老师").start();
        new Thread(t,"黄牛党").start();
    }

}
