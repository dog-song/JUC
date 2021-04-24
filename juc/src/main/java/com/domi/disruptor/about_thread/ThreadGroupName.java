package com.domi.disruptor.about_thread;

/**
 * @author domisong.
 * @description: 线程组
 * @date 2021/3/30.
 */
public class ThreadGroupName implements Runnable{


    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(threadGroup, new ThreadGroupName(), "T1");
        Thread t2 = new Thread(threadGroup, new ThreadGroupName(), "T2");

        t1.start();
        t2.start();

        System.out.println("------------------------------");
        System.out.println(threadGroup.activeCount());
        System.out.println("------------------------------");
        threadGroup.list();
        System.out.println("------------------------------");

    }


    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName()
                + "-" + Thread.currentThread().getName();

        while (true) {
            System.out.println("I am " + groupAndName);
            System.out.println("------------------------------");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
