package com.domi.disruptor.utils;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/28.
 */
public class Random {


    public static void main(String[] args) {

        //先随机产生一个下标再获取元素
        /*int random ;
        int[] doc = {200, 404, 405, 500};
        int index = (int) (Math.random() * doc.length);
        random = doc[index];
        System.out.println(random);*/


        // 生成 10-3000随机数

        for (int i = 0; i < 100; i++) {

            /*int max=6000, min=100;

            long randomNum = System.currentTimeMillis();

            int ran3 = (int) (randomNum%(max-min)+min);

            System.out.println(ran3);*/

            int max=10000000, min=10;

            int ran2 = (int) (Math.random() * (max-min) * Math.random());

            System.out.println(ran2);



        }


    }

}
