package com.domi.disruptor.juc.c_001;

import com.sun.jmx.snmp.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Domi on 2020/09/27.
 */
public class T {
    private static int count = 10;
    private static Object o = new Object();

    public static void m(){
        synchronized (o){ // 任何线程要执行下面的代码，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public static void main(String[] args) {
//        m();

//        Long  time = System.currentTimeMillis();  //当前时间的时间戳
//        long zero = time/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset();
//        System.out.println(new Timestamp(zero));//今天零点零分零秒
//        System.out.println(zero/1000);

        long time = Long.parseLong("1601194315000");
        SimpleDateFormat stttt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String time_Date = sdf.format(new Date(time));
        System.out.println("TIME---->:" + time_Date);

        String stamp = null;
        try {
            stamp = String.valueOf(stttt.parse(time_Date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("今天的零点 ----->" + stamp);



        // 昨天的0点毫秒值
        long zeroYesterday = Long.parseLong(stamp)-(Long.parseLong(stamp) + TimeZone.getDefault().getRawOffset())%(1000*3600*24) - 86400000;
        System.out.println("昨天的零点-->" + zeroYesterday);
        System.out.println(stttt.format(new Date(zeroYesterday)));

        // 昨天的23:59的毫秒值
        long finalYesterday = Long.parseLong(stamp) - 1000;
        System.out.println("昨天的23点-->" + finalYesterday);
        System.out.println(stttt.format(new Date(finalYesterday)));




        int a = 9;
        int b = 7;
        System.out.println((float)a/b);
    }


}
