package com.domi.disruptor.about_thread.state;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestSleep2 {
    public static void main(String[] args) throws InterruptedException {

        TestSleep2 testSleep2 = new TestSleep2();

        //获取系统时间
        Date startTime = new Date(System.currentTimeMillis());

        while (true) {
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            Thread.sleep(1000);
            startTime = new Date(System.currentTimeMillis());
        }

    }

    //倒计时方法
    private void tenDown() throws InterruptedException {
        int num = 10;
        for (int i = 10; i > 0; i--) {
            Thread.sleep(1000);
            System.out.println("倒计时:"+i);
        }

    }


}
