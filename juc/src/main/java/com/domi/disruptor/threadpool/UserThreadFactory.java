package com.domi.disruptor.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 自定义线程工厂
 *
 * @author <a href="mailto:domi.song@cloudwise.com">domisong</a>
 * @since 2021/6/24
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "UserThreadFactory's " + whatFeatureOfGroup + "-Worker-";
    }


    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);

        System.out.println(thread.getName());

        return thread;
    }
}


/**
 * 任务执行体
 * @author <a href="mailto:domi.song@cloudwise.com">domi</a>
 * @since 2021/6/24.
 */
class Task implements Runnable {

    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}
