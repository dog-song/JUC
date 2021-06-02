package com.domi.disruptor.about_thread.gaoji;

//死锁问题
//两个线程抱着自己的锁 , 然后想要对方的锁 .
// 于是产生一个问题 ---> 死锁
public class DeadLocked {

    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"白雪公主");
        Makeup g2 = new Makeup(1,"灰姑凉");

        new Thread(g1).start();
        new Thread(g2).start();

    }


}

//化妆
class Makeup implements Runnable{

    //选择
    int choice;
    //谁进来了
    String girlName;

    //两个对象
    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();

    public Makeup(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆的方法
    public void makeup() throws InterruptedException {
        if (choice==0){ //先拿口红,再拿镜子
            synchronized (lipStick){
                System.out.println("拿到口红");
                Thread.sleep(1000);
                //等待拿镜子的人释放锁
                synchronized (mirror){
                    System.out.println("拿到镜子");
                }
            }

        }else { //先拿镜子 , 再拿口红
            synchronized (mirror){
                System.out.println("拿到镜子");
                Thread.sleep(2000);
                //等待拿口红的人释放锁
                synchronized (lipStick){
                    System.out.println("拿到口红");
                }
            }
        }

    }

}





//口红
class LipStick{

}

//镜子
class Mirror{

}
