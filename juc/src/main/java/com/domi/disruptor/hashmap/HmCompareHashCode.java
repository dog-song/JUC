package com.domi.disruptor.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/16.
 */
public class HmCompareHashCode {


    /**
     * 比较 Map中的顺序不一样的时候，他们的hashcode是否相同
     *
     * @description: TODO
     * @param args
     * @return void
     * @author domisong.
     * @date: 2021/4/16.
     */
    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("aaa", 111);
        map1.put("bbb", 222);
        map1.put("ccc", 333);
        map1.put("cccc", 333);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("ccc", 333);
        map2.put("cccc", 333);
        map2.put("bbb", 222);
        map2.put("aaa", 111);


        if (map1.hashCode() == map2.hashCode()) {
            System.out.println("map1 = map2");
        } else {
            System.out.println("map1 != map2");
        }

    }

    public static void goTo() {

    }

}
