package com.domi.disruptor.hashmap;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/17.
 */
public class StringHM {


    private static String aaa = "AAA";

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("iphone");

        // sb 被改变了，变成了"iphone4"。
        foo(sb);
        System.out.println(sb);

        // sb 没有被改变，还是 "iphone"。
        StringBuilder sb2 = new StringBuilder("iphone");
        foo2(sb2);
        System.out.println(sb2);


        // "AAA" 字符串对象没有被改变。（没有被任何引用所指向的对象是垃圾，会被垃圾回收器回收）
        aaa = "BBB";
        System.out.println(aaa);

    }

    static void foo(StringBuilder builder) {
        builder.append("4");
    }

    static void foo2(StringBuilder builder) {
        builder = new StringBuilder("ipad");
    }

}
