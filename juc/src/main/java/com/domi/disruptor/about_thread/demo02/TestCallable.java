package com.domi.disruptor.about_thread.demo02;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//JUC并发编程
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {

    private String url;
    private String name;

    public TestCallable(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        //下载图片
        WebDownloader webDownloader = new WebDownloader();//下载器
        webDownloader.downloader(url,name);//下载文件的方式
        System.out.println("下载了图片-->"+name);
        return true;
    }

    //启动线程
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/1.jpg","你好1.jpg");
        TestCallable t2 = new TestCallable("https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/2.jpg","你好2.jpg");
        TestCallable t3 = new TestCallable("https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/3.jpg","你好3.jpg");

        //创建执行服务：
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行：
        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);

        //获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();

        //判断线程是否顺利结束或者有异常

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        //关闭服务
        ser.shutdownNow();





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
