package com.onejava.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.onejava.async.Util.*;
/*
1. To illustrate handling exception using whenComplete()
2. whenComplete() It does not swallow exception
3. It takes result and exception. One of these two objects is null. They are passed to biConsumer.
4. The returned CompletableFuture returns the same thing as the calling one.
 */
public class Sample011 {
    public static void main(String[] args) {
        CompletableFuture<List<Integer>> supply = CompletableFuture.supplyAsync(() -> throwExceptionWhileGettingUserIDs());
        //CompletableFuture<List<Integer>> supply = CompletableFuture.supplyAsync(() -> getUserIDs());
        CompletableFuture<List<Integer>> exception = supply.whenComplete((list, ex) -> testTheResult(list, ex));
        CompletableFuture<List<User>> fetch = exception.thenApply(ids -> getUsers(ids));
        CompletableFuture<Void> display = fetch.thenAccept(users -> displayUsers(users));

        //supply.join();  // It gives CompletionException: IllegalStateException
        sleep(2500);
        System.out.println("Supply  : done=" + supply.isDone() + " Exception=" + supply.isCompletedExceptionally());
        System.out.println("fetch  : done=" + fetch.isDone() + " Exception=" + fetch.isCompletedExceptionally());
        System.out.println("display  : done=" + display.isDone() + " Exception=" + display.isCompletedExceptionally());
    }
}
