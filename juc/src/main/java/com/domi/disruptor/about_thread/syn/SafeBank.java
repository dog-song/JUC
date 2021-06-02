package com.domi.disruptor.about_thread.syn;

public class SafeBank {


    public static void main(String[] args) {
        Account2 account = new Account2(100,"招商卡");

        Bank2 you = new Bank2("痛苦的你",account,50);
        Bank2 wife = new Bank2("开心的媳妇",account,100);

        you.start();
        wife.start();
    }
}

//账户
//实体类
class Account2{
    int money;//余额
    String name; //卡名

    public Account2(int money, String name) {
        this.money = money;
        this.name = name;
    }
}


//银行
class Bank2 extends Thread{
    //存钱:存了多少,取钱:取了多少

    Account2 account;  //账户
    int drawingMoney; //取了多少钱
    int nowMoney; //手里有多少钱

    public Bank2(String name,Account2 account,int drawingMoney){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        drwaing();
    }

    //synchronized本身锁的是this.就是这个对象本身
    public void drwaing(){

        //提高性能的代码
        if (account.money<=0){
            return;
        }

        //如何判断锁的对象
        // 谁需要实现增删改就去锁定他
        synchronized (account){

            //判断能否取钱
            if (account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"活该,没取到钱");
                return;
            }

            //为了放大问题发生性,我们加个延时.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //余额 = 余额 - 你去走的钱
            account.money = account.money - drawingMoney;
            //你的钱 = 你的钱 + 你取的钱
            nowMoney = drawingMoney + nowMoney;

            System.out.println(this.account.name+"账户余额:"+account.money);
            System.out.println(this.getName()+"手里的钱:"+nowMoney);
        }

    }
}