package com.onejava.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.onejava.async.Util.*;
/*
1. To illustrate handling exception using handle()
2. handle() swallows exception and return default value and pipeline continues.
3. It takes result and exception. One of these two objects is null. They are passed to biFunction
that produces a result. And this result is returned by this CompletableFuture.
4. The biFunction can either process and swallow exception, or rethrow it as needed
 */
public class Sample012{
    public static void main(String[] args) {
        CompletableFuture<List<Integer>> supply = CompletableFuture.supplyAsync(() -> throwExceptionWhileGettingUserIDs());
        //CompletableFuture<List<Integer>> supply = CompletableFuture.supplyAsync(() -> getUserIDs());
        CompletableFuture<List<Integer>> exception = supply.handle((list, ex) -> handleTheResult(list, ex));
        CompletableFuture<List<User>> fetch = exception.thenApply(ids -> getUsers(ids));
        CompletableFuture<Void> display = fetch.thenAccept(users -> displayUsers(users));

        //supply.join();  // It gives CompletionException: IllegalStateException
        sleep(2500);
        System.out.println("Supply  : done=" + supply.isDone() + " Exception=" + supply.isCompletedExceptionally());
        System.out.println("fetch  : done=" + fetch.isDone() + " Exception=" + fetch.isCompletedExceptionally());
        System.out.println("display  : done=" + display.isDone() + " Exception=" + display.isCompletedExceptionally());
    }
}
