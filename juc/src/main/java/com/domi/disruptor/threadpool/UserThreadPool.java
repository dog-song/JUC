package com.domi.disruptor.threadpool;

import java.util.concurrent.*;

/**
 * 优雅的启动一个线程池
 *
 * @author <a href="mailto:domi.song@cloudwise.com">domisong</a>
 * @since 2021/6/24
 */
public class UserThreadPool {

    public static void main(String[] args) {

        // 缓存队列设置固定长度为2，为了快速触发 rejectHandler
        BlockingQueue queue = new LinkedBlockingQueue(2);

        // 线程任务来源
        UserThreadFactory factory1 = new UserThreadFactory("第一机房");
        UserThreadFactory factory2 = new UserThreadFactory("第二机房");

        // 拒绝策略
        UserRejectHandler handler = new UserRejectHandler();

        // 核心线程为1，最大线程为2，todo 保证触发rejectHandler
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, queue, factory1, handler);

        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, queue, factory2, handler);

        // 创建400个线程
        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
    }

}
