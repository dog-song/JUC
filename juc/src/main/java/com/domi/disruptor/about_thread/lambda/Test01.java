package com.domi.disruptor.about_thread.lambda;

/**
 * @description: lambda表达式的推演过程
 * @author domisong.
 * @date 2021/6/1.
 */
public class Test01 {

    /** 静态内部类 */
    static class Test02 implements Runnable{
        @Override
        public void run() {
            System.out.println("你好呀lambda！");
        }
    }


    public static void main(String[] args) {
        Test02 test02 = new Test02();
        new Thread(test02).start();

        /** 局部内部类 */
        class Test03 implements Runnable{
            @Override
            public void run() {
                System.out.println("你好呀lambda2！");
            }
        }

        Test03 test03 = new Test03();
        new Thread(test03).start();


        /** 匿名内部类, 需要有一个借口或者父类 */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("你好呀lambda3！");
            }
        }).start();

        /** lambda  jdk.8新增方式 */
        new Thread(()->{
            System.out.println("你好呀lambda4！");
        }).start();


    }
}