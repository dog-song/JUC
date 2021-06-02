package com.domi.disruptor.reflect;

import com.domi.disruptor.reflect.annotation.FieldName;
import com.domi.disruptor.reflect.annotation.TableName;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/5/31.
 */
public class Test03 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.domi.disruptor.reflect.pojo.User");

        // 通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获得values的值
        TableName tableName = (TableName) c1.getAnnotation(TableName.class);
        String value = tableName.value();
        System.out.println(value);

        // 获得类指定的注解
        Field field = c1.getDeclaredField("name");
        FieldName annotation = field.getAnnotation(FieldName.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }

}


