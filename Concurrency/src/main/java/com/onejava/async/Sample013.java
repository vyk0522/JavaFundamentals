package com.onejava.async;

import java.util.concurrent.CompletableFuture;

import static com.onejava.async.Util.*;

/*
1. To illustrate order of execution of delayed start.
A. The CompletableFuture or chain of CompletableFutures, whichever is nearer to complete() executes first.
B. In chain of CompletableFutures, After completion of one CompletableFuture other executes.
Note: Delayed start means CompletableFuture, which needs to be completed explicitly by invoking complete()
C. Here start CompletableFuture, completes in main thread. And, triggers all the chained tasks in main thread only.
D. start.completeAsync(() -> null, executor); // start CompletableFuture, executes and completes in thread from executorPool of threads that is passed.
 */
public class Sample013 {
    public static void main(String[] args) {
        CompletableFuture<Void> start = new CompletableFuture<>();
        start.thenRun(() -> dummy("Dummy 4 by: ")); // executes Fourth
        start.thenRun(() -> dummy("Dummy 3 by: ")); // executes Third

        // This is chain of CompletableFutures and executes Second
        start
                .thenApply(nil -> getUserIDs())
                .thenApply(ids -> getUsers(ids))
                .thenAccept(users -> displayUsers(users))
                .thenRun(() -> logMessage());

        start.thenRun(() -> dummy("Dummy 1 by: ")); // This is single CompletableFuture. As Nearer to complete(), it executes first.

        start.complete(null);
        System.out.println("Done executing main() by: " + Thread.currentThread().getName());
    }
}
