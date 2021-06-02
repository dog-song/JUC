package com.domi.disruptor.about_thread.gaoji;

//生产者消费2
//生产者--->演员
//消费者--->观众
//产品:信号灯--->电视----->声音

public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();

        new Player(tv).start();
        new Watcher(tv).start();
    }
}


//生产者
class Player extends Thread{
    TV tv;

    public Player(TV tv){
        this.tv = tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                this.tv.play("节目:快乐大本营播放中");
                System.out.println();
            }else {
                this.tv.play("广告:抖音,记录美好生活");
            }
        }
    }
}

//消费者
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//电视
class TV{
    //演员说话 , 观众等待
    //观众观看 , 演员等待
    boolean flag = true;

    //说话
    String voice;

    //表演
    public synchronized void play(String voice){

        //演员等待
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("表演了"+voice);
        this.voice = voice;

        //让观众观看
        this.notifyAll();
        this.flag = !this.flag;

    }


    //观看
    public synchronized void watch(){


        //观众等待
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("观众听到了: "+voice);

        //通知演员说话
        this.notifyAll();

        this.flag = !this.flag;
    }

}