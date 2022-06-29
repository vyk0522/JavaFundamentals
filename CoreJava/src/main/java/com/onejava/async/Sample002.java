package com.onejava.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
1. To illustrate usage of CompletableFuture pattern to execute threads using executor pool of threads
 */
public class Sample002 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable task = () -> System.out.println("I am running asynchronously in the thread: " + Thread.currentThread().getName());
        CompletableFuture.runAsync(task, executor);
        executor.shutdown();
    }
}
