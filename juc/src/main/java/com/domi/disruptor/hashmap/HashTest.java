package com.domi.disruptor.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.sun.tools.internal.xjc.reader.Ring.add;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/5/20.
 */
public class HashTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Collections.<String>nCopies(8, "0"));
        list.set("a".hashCode() & 8 - 1, "a");
        list.set("b".hashCode() & 8 - 1, "b");
        list.set("c".hashCode() & 8 - 1, "c");
        list.set("d".hashCode() & 8 - 1, "d");
        list.set("e".hashCode() & 8 - 1, "e");
        list.set("f".hashCode() & 8 - 1, "f");
        list.set("g".hashCode() & 8 - 1, "g");

        System.out.println("元素集合:" + list);

        System.out.println("获取元素 f [\"f\".hashCode() & 8 - 1)] Idx："
                + ("f".hashCode() & (8 - 1)) + " 元素：" + list.get("f".hashCode() & 8 - 1));

        System.out.println("获取元素 e [\"e\".hashCode() & 8 - 1)] Idx："
                + ("e".hashCode() & (8 - 1)) + " 元素：" + list.get("e".hashCode() & 8 - 1));

        System.out.println("获取元素 d [\"d\".hashCode() & 8 - 1)] Idx："
                + ("d".hashCode() & (8 - 1)) + " 元素：" + list.get("d".hashCode() & 8 - 1));
    }

}
