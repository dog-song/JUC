package com.domi.disruptor.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author domisong.
 * @description: 内置注解
 * @date 2021/5/31.
 */

// SuppressWarnings 略所有警告
@SuppressWarnings("all")
public class Test01 {

    // Override重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    // Deprecated不推荐使用，但是可以使用，或者存在更好的方式
    @Deprecated
    public static void test() {
        System.out.println("1111");
    }


    public void test02() {
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
