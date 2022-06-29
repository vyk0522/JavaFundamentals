package com.onejava.async;

import java.util.concurrent.*;

/*
1. To illustrate creating tasks using Runnable and Callable
2. To execute tasks using Executor pattern
3. Getting results from tasks using Executor pattern
4. To execute tasks using CompletableFuture pattern
 */
public class Sample001 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // Creating tasks
        Runnable task1 = () -> System.out.println("Task1 prints some text");
        Callable<String> task2 = () -> getGreeting();

        // Executing tasks using
        Future<?> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);

        // Getting results from tasks
        System.out.println(future1.get());  // null
        System.out.println(future2.get());  // Hello

        // Executing tasks using CompletableFuture pattern
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(task1);
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> getGreeting());
        executor.shutdown();
    }

    public static String getGreeting() {
        return "Hello";
    }
}
