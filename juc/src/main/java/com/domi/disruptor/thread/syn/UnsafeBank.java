package com.domi.disruptor.thread.syn;


//银行(存钱:存了多少,取钱:去了多少) , 两个人 , 账户
//并发问题,线程不安全

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"招商卡");

        Bank you = new Bank("痛苦的你",account,50);
        Bank wife = new Bank("开心的媳妇",account,100);

        you.start();
        wife.start();
    }
}


//账户
class Account{
    int money;//余额
    String name; //卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}


//银行
class Bank extends Thread{
    //存钱:存了多少,取钱:取了多少

    Account account;  //账户
    int drawingMoney; //取了多少钱
    int nowMoney; //手里有多少钱

    public Bank(String name,Account account,int drawingMoney){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {

        //判断能否取钱
        if (account.money-drawingMoney<0){
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