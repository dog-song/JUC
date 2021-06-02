package com.domi.disruptor.about_thread.demo01;


//多线程实现图片下载

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread {

    //
    private String url;
    private String name;

    public TestThread2(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        //下载图片
        WebDownloader webDownloader = new WebDownloader();//下载器
        webDownloader.downloader(url,name);//下载文件的方式
        System.out.println("下载了图片-->"+name);

    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/1.jpg","你好1.jpg");
        TestThread2 t2 = new TestThread2("https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/2.jpg","你好2.jpg");
        TestThread2 t3 = new TestThread2("https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/3.jpg","你好3.jpg");

        t1.start();
        System.out.println("执行了t1");
        t2.start();
        System.out.println("执行了t2");
        t3.start();
        System.out.println("执行了t3");
    }
}

//下载图片
class WebDownloader{

    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            //输出异常信息
            System.out.println("downloader方法出现异常");
        }
    }

}
