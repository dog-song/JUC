package com.domi.disruptor.thread.return_value;

import java.util.concurrent.Callable;

/**
 * TODO
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/8/28
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");

        Thread.sleep(5000);
        System.out.println("task done");
        return value;
    }
}
