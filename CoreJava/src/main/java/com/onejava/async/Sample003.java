package com.onejava.async;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static com.onejava.async.Util.*;

/*
1. To illustrate the usage of join() and complete().
2. It checks whether the task is done or not. If it is done, then it does nothing.
If it is not done, then it completes it and sets the return value to value passed as parameter.
 */
public class Sample003 {
    public static void main(String[] args) {
        Supplier<String> task = () -> getThreadName();
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(task);

        // To get the result of task. Because of join() main thread waits until result is returned
        String result = completableFuture1.join();
        System.out.println(result);  // ForkJoinPool.commonPool-worker-9

        // It checks whether completableFuture is completed or not. here it is completed because of join()
        // that is why it does not do anything
        completableFuture1.complete("Too long!");
        System.out.println(result);  // ForkJoinPool.commonPool-worker-9

        // Here completableFuture is not completed when complete() is invoked.
        // So complete() completes it and sets return value as Too long
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(task);
        completableFuture2.thenAccept(output -> System.out.print(""));
        //sleep(1000);
        completableFuture2.complete("Too long");
        System.out.println(completableFuture2.join()); // Too long

    }

}
