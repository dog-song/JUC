package com.domi.disruptor.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/27.
 */
public class TestDeliveryMethod {


    // static  String[] str = {"a", "b", "c"};

    /**
     *
     * 思考: Java到底是值传递还是引用传递
     * 讨论：https://www.zhihu.com/question/31203609
     *
     */
    public static void main(String[] args) {
        String[] str = {"a", "b", "c"};
        List<String> stringList = Arrays.asList(str);
        System.out.println(Arrays.toString(str)); // a ,b, c

        stringList.set(0, "d");

        System.out.println(Arrays.toString(str)); // d ,b, c


        List<String> list = new ArrayList<>(Arrays.asList(str));

    }






    public static void test() {
        String[] str = {"a", "b", "c"};
        List<String> stringList = Arrays.asList(str);
        System.out.println(Arrays.toString(str));

        stringList.set(0, "d");
        System.out.println(Arrays.toString(str));
    }

}
