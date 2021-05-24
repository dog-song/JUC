package com.domi.disruptor.unsafe;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/27.
 */
public class TestUnsafe1 {

    private int anInt = 0;

    public static void main(String[] args) {
        TestUnsafe1 testUnsafe1 = new TestUnsafe1();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    testUnsafe1.anInt++;

                    System.out.println(testUnsafe1.anInt);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    testUnsafe1.anInt++;

                    System.out.println(testUnsafe1.anInt);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
