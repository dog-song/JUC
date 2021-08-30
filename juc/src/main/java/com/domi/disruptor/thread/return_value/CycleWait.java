package com.domi.disruptor.thread.return_value;


/**
 * 实现处理线程的返回值：
 *      主线程等待法；
 *      使用 Thread#join() 方法阻塞当前线程，来等待子线程处理完毕；
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/8/28
 */
public class CycleWait implements Runnable{

    private String value;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread thread = new Thread(cw);
        thread.start();

        /*while (cw.value == null) {
            Thread.sleep(100);
        }*/

        thread.join();

        System.out.println("value : " + cw.value);
    }
}
