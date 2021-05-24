package com.domi.disruptor.basic;

import com.sun.beans.finder.FieldFinder;

import java.lang.reflect.Field;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/27.
 */
public class TestString {

    /**
     String 真的是不可变的吗？
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "domi";
        System.out.println(str);
        System.out.println();

        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        char[] chars = (char[]) field.get(str);
        chars[0] = 'D';

        System.out.println(str);
    }

}
