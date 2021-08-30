package com.domi.disruptor.thread.lambda;

//lambda表达式在多线程中的使用
public class Test04 {
    public static void main(String[] args) {

        //原先方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("你好二");
            }
        }).start();

        //线程体只有一行可以省略到极致
        new Thread(()-> System.out.println("你好二")).start();

        //如果线程体有多行 , 用一个代码块包裹起来就好.
        new Thread(()-> {
            for (int i = 0; i < 40; i++) {
                System.out.println("你好二");
            }
        }).start();

    }
}
