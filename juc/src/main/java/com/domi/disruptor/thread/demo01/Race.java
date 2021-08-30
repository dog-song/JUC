package com.domi.disruptor.thread.demo01;


//龟兔赛跑
public class Race implements Runnable{

    //winner:只有一个胜利者
    private static String winner;

    @Override
    public void run() {
        //赛道
        for (int step = 1; step <= 101; step++) {

            //兔子休眠
            if (Thread.currentThread().getName().equals("兔子") && step % 50==0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束
            boolean flag = gameOver(step);
            if (flag){
                break;
            }

            System.out.println(Thread.currentThread().getName()+"跑了"+ step +"步");

        }
    }

    //判断比赛是否结束
    private boolean gameOver(int step){
        if (winner!=null){ //如果存在胜利者
            return true;
        }
        if (step>=100){  //如果跑到了比赛结束
            winner = Thread.currentThread().getName();
            System.out.println("比赛结束");
            System.out.println("胜利者----->"+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }


}
