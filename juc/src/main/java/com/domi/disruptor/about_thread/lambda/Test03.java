package com.domi.disruptor.about_thread.lambda;


/**
 * @description:
 *              lambda表达式传递参数
 *              隐式前提
 *              只有一个参数的情况下,可以简化参数类型 , 参数括号 .
 *              只有一行代码的情况下 , 可以省略大括号 .
 *              --------------------------------
 *              总结
 *                lambda表达式只能有一行代码的情况下才能简化成为一行，如果有多行，那么就用代码块包裹
 *                前提是 接口为函数式接口
 * @author domisong.
 * @date 2021/6/1.
 */
public class Test03 {
    public static void main(String[] args) {
        ILove love = new Love();
        love.lambda(1);

        //匿名内部类
        love = new ILove() {
            @Override
            public void lambda(int a) {
                System.out.println("我开始喜欢lambda了...."+a);
            }
        };
        love.lambda(2);


        //lambda表达式
        love = (int a)->{
            System.out.println("我开始喜欢lambda了...."+a);
        };
        love.lambda(3);


        //简化1: 去掉括号 和 类型
        love = a->{
            System.out.println("我开始喜欢lambda了...."+a);
        };
        love.lambda(4);


        //简化2:去掉花括号
        love = a->System.out.println("我开始喜欢lambda了...."+a);

        love.lambda(5);

    }
}


//函数式接口
interface ILove{
    void lambda(int a);
}

class Love implements ILove{
    @Override
    public void lambda(int a) {
        System.out.println("我开始喜欢lambda了...."+a);
    }
}