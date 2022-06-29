package com.onejava.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.onejava.async.Util.*;
/*
To illustrate below concepts
1. If CompletableFuture is completed by the time main thread reaches CompletableFuture's next task to be completed, then next task will be executed by main thread itself.
2. If CompletableFuture is not completed by the time main thread reaches CompletableFuture's next task to be completed. then main thread continues to next line,
 letting the pool threads to complete the pending tasks.
3. This is also chaining of tasks but we are capturing them to reference variable.
4. If main thread starts executing the task, unless we don't mention pool of thread, all remaining chained tasks will be executed by main thread only.
 */
public class Sample014 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // This task takes 500MS and executed by ForkJoinPool thread
        // This is root CompletableFuture task. Not child task which is derived from another CompletableFuture. And it executes always in ForkJoinPool or ExecutorPool of threads
        CompletableFuture<List<Integer>> completableFuture = CompletableFuture.supplyAsync(() -> getUserIDs());

        // ForkJoinPool thread only executes this next task because above task is not completed by the time, main thread reaches here.
        // This task takes 1000MS
        CompletableFuture<List<User>> usersCompletableFuture = completableFuture.thenApply(ids -> getUsers(ids));
        sleep(1600);

        // Main thread executes this next task because above usersCompletableFuture task is completed by the time, main thread reaches here.
        CompletableFuture<Void> displayCompletableFuture = usersCompletableFuture.thenAccept(users -> displayUsers(users));

        // Rest all chained CompletableFutures executed by main Thread only but as we passed executor, it will be run by executor pool of threads
        // Executed by executor pool of thread and it takes 100MS to complete
        CompletableFuture<Void> loggerCompletableFuture = displayCompletableFuture
                .thenRunAsync(() -> logMessage(), executor);
        sleep(300);

        // Main thread executes next task because above task is completed by the time, main thread reaches here.
        // If main thread does not take much time by sleeping, then executor pool of thread would have executed this task
        loggerCompletableFuture
                .thenRun(() -> dummy("Dummy 1 by: "));

        // Rest all chained CompletableFutures executed by main Thread. Because main thread executed the previous task and we didn't change the thread by passing executor, or ForkJoinPool.
        loggerCompletableFuture.thenRun(() -> dummy("Dummy 2 by: ")).thenRun(() -> dummy("Dummy 3 by: "));
        loggerCompletableFuture.thenRun(() -> dummy("Dummy 4 by: "));

        // Note:If executor thread is executing the previous task and enter below line. Then main thread, executes the below task as completableFuture task is already completed.
        completableFuture.thenApply(ids -> getUsers(ids));

        executor.shutdown();
    }
}
