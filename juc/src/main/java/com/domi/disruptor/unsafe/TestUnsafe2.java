package com.domi.disruptor.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/27.
 */
public class TestUnsafe2 {

    private int anInt = 0;
    private static sun.misc.Unsafe UNSAFE;
    private static long OFFSET;


    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
            OFFSET = UNSAFE.objectFieldOffset(TestUnsafe2.class.getDeclaredField("anInt"));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestUnsafe2 testUnsafe2 = new TestUnsafe2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    boolean b = UNSAFE.compareAndSwapInt(testUnsafe2, OFFSET, testUnsafe2.anInt, testUnsafe2.anInt+1);

                    if (b) {
                        System.out.println(UNSAFE.getIntVolatile(testUnsafe2, OFFSET));
                    }
                    try {
                        Thread.sleep(400);
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

                    boolean b = UNSAFE.compareAndSwapInt(testUnsafe2, OFFSET, testUnsafe2.anInt, testUnsafe2.anInt + 1);

                    if (b) {
                        System.out.println(UNSAFE.getIntVolatile(testUnsafe2, OFFSET));
                    }
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
