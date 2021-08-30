package com.domi.disruptor.thread;

/**
 * @author domisong.
 * @description: 守护进程daemon
 * @date 2021/3/31.
 */
public class DaemonDemo {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new DaemonT();

        t.setDaemon(true);
        t.start();

        Thread.sleep(2000);
    }


    public static class DaemonT extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("I am alive.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
