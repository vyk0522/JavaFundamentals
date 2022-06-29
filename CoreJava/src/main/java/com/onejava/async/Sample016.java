package com.onejava.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.onejava.async.Util.*;
/*
1. To illustrate thread execution
A. First task is Executed in common ForkJoinPool and Second task is executed in the same thread as the triggering task
B. First task is Executed in common ForkJoinPool and Second task is executed in in environment specified executor generally common ForkJoinPool
C. First task is Executed in executor pool and Second task is executed in the same thread as the triggering task
D. First task is Executed in common ForkJoinPool and Second task is executed in executor pool and Third task is executed in executor pool.
E. thenApplyAsync(), thenRun() and thenAcceptAsync() runs parallel
 */

/*
When thenApplyAsync(), thenRun() and thenAccept() runs parallel

Executing getUserIDs() by: ForkJoinPool.commonPool-worker-9
Size is: 3 and executed by: ForkJoinPool.commonPool-worker-9
Executing logMessage() by: ForkJoinPool.commonPool-worker-9
Users Has been read!
Executing getUsers() by: pool-1-thread-1
 */

/*
When thenApplyAsync(), thenRun() and thenAcceptAsync() runs parallel

Executing getUserIDs() by: ForkJoinPool.commonPool-worker-9
Executing logMessage() by: ForkJoinPool.commonPool-worker-9
Users Has been read!
Size is: 3 and executed by: ForkJoinPool.commonPool-worker-2
Executing getUsers() by: pool-1-thread-1
*/

public class Sample016 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //CompletableFuture.supplyAsync(() -> getUserIDs()).thenApply(ids -> getUsers(ids));

        // CompletableFuture.supplyAsync(() -> getUserIDs()).thenApplyAsync(ids -> getUsers(ids));

        //CompletableFuture.supplyAsync(() -> getUserIDs(), executor).thenApply(ids -> getUsers(ids));

        // CompletableFuture.supplyAsync(() -> getUserIDs()).thenApplyAsync(ids -> getUsers(ids), executor).thenRun(() ->logMessage());

        CompletableFuture<List<Integer>> completableFuture = CompletableFuture.supplyAsync(() -> getUserIDs()); // Executes in common ForkJoinPool worker-9
        completableFuture.thenApplyAsync(ids -> getUsers(ids), executor); // Executes in executor pool
        completableFuture.thenRun(() ->logMessage());  // Executes in common ForkJoinPool worker-9
        //completableFuture.thenAccept(ids -> dummy("Size is: " +ids.size() + " and executed by: ")); // thenAccept runs in same thread from same pool (common ForkJoinPool worker-9)
        completableFuture.thenAcceptAsync(ids -> dummy("Size is: " +ids.size() + " and executed by: ")); // thenAcceptAsync runs in different thread from same pool(common ForkJoinPool worker-2)

        sleep(3000);
        executor.shutdown();
    }
}
