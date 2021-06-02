package com.domi.disruptor.about_thread.demo02;

/**
 * @description:
 *          静态代理
 *              真实对象和代理对象都要实现同一个接口
 *              代理对象要代理真实角色
 *              -------------------------
 *          优点：
 *              代理对象可以做很多真实对象做不了的事情
 *              真实对象专注做自己的事情
 *
 * @author domisong.
 * @date 2021/6/1.
 */
public class StaticProxy {

    public static void main(String[] args) {
        //代理对象  代理 真实对象
        You you = new You();
        you.happyMarry();
        new WeddingCompany(you).happyMarry();
    }

}


/**
 * @description: 真实对象：你
 * @author domisong.
 * @date 2021/6/1.
 */
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("我要结婚了，好hi呦");
    }
}


/**
 * @description: 代理对象：婚庆公司
 * @author domisong.
 * @date 2021/6/1.
 */
class WeddingCompany implements Marry{

    /** 婚庆需要有你这个人 ， 代理对象需要代理一个真实对象 */
    private Marry you;

    public WeddingCompany(Marry you){
        this.you = you;
    }

    @Override
    public void happyMarry() {
        before();
        this.you.happyMarry();//你要结婚
        after();
    }

    private void before() {
        System.out.println("结婚之前，布置洞房");
    }
    private void after() {
        System.out.println("结婚之后，催你收钱");
    }

}


/**
 * @description: 共同的接口：结婚
 * @author domisong.
 * @date 2021/6/1.
 */
interface Marry{

    void happyMarry();

}
