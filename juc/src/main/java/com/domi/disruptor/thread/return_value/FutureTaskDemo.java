package com.domi.disruptor.thread.return_value;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/8/28
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());

        new Thread(task).start();

        if (!task.isDone()) {
            System.out.println("task has not finished, please wait!");
        }
        System.out.println("task return: " + task.get());
    }

}
