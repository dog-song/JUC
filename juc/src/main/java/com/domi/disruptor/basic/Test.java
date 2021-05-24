package com.domi.disruptor.basic;

import com.google.common.collect.Lists;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/27.
 */
public class Test {

    public static void main(String[] args) {
        String id = "12";

        System.out.println(Lists.newArrayList(id));

        long two = 1 << 16;

        System.out.println(two);

        int a = 3;
        // | 或操作
        int b = a | 1;

        System.out.println(b);


        int c = 2; // 0010
        int d = 3; // 0011

        // & 与操作
        int e = c & d;

        System.out.println(e);

        // ^ 异或运算
        int i = c ^ d;
        System.out.println(i);


        System.out.println("------");


        int eor = 12;
        System.out.println(eor & (~eor + 1));
    }

}
