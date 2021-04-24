package com.domi.disruptor.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/7.
 */
public class L01_Array {

    public static void main(String[] args) {
        /*String[] str = {"a", "b", "c"};

        List<String> strings = Arrays.asList(str);

        strings.set(1, "domi");
        System.out.println(strings.toString());

        // 报错: java.lang.UnsupportedOperationException
        strings.add("aaa");*/


        long to = System.currentTimeMillis();


        System.out.println(to);

        // 0000 1000
        int a = 8;

        int b = a | 1;

        System.out.println(b);


        String str = "VPN登录桌面云鼠标对不上或者鼠标飘|鼠标移动到显示中间正上，设置，分辨率自适应勾选去掉，鼠标飘，点击设置，输入/输出选择关闭相对模式。";

        String[] split = str.split("\\|");

        System.out.println(split[0]);



    }
}
