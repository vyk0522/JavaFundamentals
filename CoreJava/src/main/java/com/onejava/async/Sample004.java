package com.onejava.async;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static com.onejava.async.Util.*;

/*
1. To illustrate the usage of join() and obtrudeValue().
2. It checks whether the task is done or not. If it is done, then forces the returned value to value.
If it is not done, then it completes it and sets the returned value to value parameter.
 */
public class Sample004 {
    public static void main(String[] args) {
        Supplier<String> task = () -> getThreadName();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(task);

        String result = completableFuture.join();
        System.out.println(result); // ForkJoinPool.commonPool-worker-9

        // Here completableFuture is completed, still it forces the returned value to value we passed.
        completableFuture.obtrudeValue("Too long!");
        result = completableFuture.join();
        System.out.println(result); // Too long!
    }

}
