package com.domi.disruptor.thread.gaoji;


//思路

//1.思考需要哪些对象?
// 生产 , 消费 , 产品 , 容器

//2.分工

/*
    生产者只管生产
    消费者只管消费
    鸡: 实体类

    容器 :

    容器添加数据.
    要判断容器是否满 , 满了等待消费者消费
    没有满,通知生产者生产

    容器减少数据
    判断还有没有数据, 没有数据的话 . 等待生产者生产
    消费完毕 , 通知生产者生产
 */


//测试生产者和消费者问题
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();

        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }
}


//生产者
class Productor extends Thread{
    //需要向容器中加入产品
    SynContainer container;
    public Productor(SynContainer container){
        this.container = container;
        }
        @Override
        public void run() {
            for (int i = 1; i < 100; i++) {
                //生产者添加产品
            container.push(new Chicken(i));
            System.out.println("生产者生产了"+i+"鸡");
        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            //消费者拿走产品
            Chicken chicken = container.pop();
            System.out.println("消费者消费了"+chicken.id+"鸡");
        }
    }
}


//缓冲区-->容器
class SynContainer{

    //容器
    Chicken[] chickens = new Chicken[10];



    //容器的计数器
    int num = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken) {

        //假如容易已经满了,就不用放,等待消费者消费
        if (num>=chickens.length){

            //等待消费者消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //假如容器没有满 , 通知生产生成

        System.out.println("num,,,,,"+num);
        chickens[num] = chicken;
        System.out.println("数组有多少个元素"+num);
        num++;
        //通知消费者消费
        this.notifyAll();

    }

    //消费者拿走产品
    public synchronized Chicken pop(){
        //假如容器空的,等待
        if (num<=0){
            //等待生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        num--;
        Chicken chicken = chickens[num];
        //通知生产者生产
        this.notifyAll();
        return chicken;
    }


}

//产品->鸡
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}