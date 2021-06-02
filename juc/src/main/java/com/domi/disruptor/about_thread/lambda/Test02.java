package com.domi.disruptor.about_thread.lambda;


//lambda表达式前提
//必须是函数式接口.
//必须有返回值(就是那个函数式接口)

public class Test02 {

    public static void main(String[] args) {
        //lambda表达式
        ILike like = ()->{
            System.out.println("我讨厌lambda。。。。5");
        };

        like.lambda();

    }
}


//函数式接口
interface ILike{
    void lambda();
}

