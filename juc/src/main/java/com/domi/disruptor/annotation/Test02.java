package com.domi.disruptor.annotation;

import java.lang.annotation.*;

/**
 * @author domisong.
 * @description: 元注解
 * @date 2021/5/31.
 */
public class Test02 {

    @MyAnnotation
    public void test() {
        System.out.println();
    }

}

/**
 * @author domisong
 */
// Target表示注解可以用在哪些地方
@Target(value = ElementType.METHOD)
// Retention表示注解在什么地方还有效
@Retention(value = RetentionPolicy.RUNTIME)
// Documented表示是否将注解生成在JavaDoc中
@Documented
// Inherited子类是否可以继承父类的注解
@Inherited
@interface MyAnnotation{

}
