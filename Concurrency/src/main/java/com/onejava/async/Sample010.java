package com.onejava.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.onejava.async.Util.*;

/*
1. To illustrate handling exception using exceptionally()
2. exceptionally() swallows exception and return default value and pipeline continues
3. This exception can also be rethrown(unchecked). In that case, Remaining chained CFs wont get executed at all and completes exceptionally.
 */
public class Sample010 {
    public static void main(String[] args) {
        CompletableFuture<List<Integer>> supply = CompletableFuture.supplyAsync(() -> throwExceptionWhileGettingUserIDs());
        //CompletableFuture<List<Integer>> supply = CompletableFuture.supplyAsync(() -> getUserIDs());
        CompletableFuture<List<Integer>> exception = supply.exceptionally(e -> Arrays.asList(99));
        CompletableFuture<List<User>> fetch = exception.thenApply(ids -> getUsers(ids));
        CompletableFuture<Void> display = fetch.thenAccept(users -> displayUsers(users));

        // supply.join();  // It gives CompletionException: IllegalStateException
        sleep(2500);
        System.out.println("Supply  : done=" + supply.isDone() + " Exception=" + supply.isCompletedExceptionally());
        System.out.println("fetch  : done=" + fetch.isDone() + " Exception=" + fetch.isCompletedExceptionally());
        System.out.println("display  : done=" + display.isDone() + " Exception=" + display.isCompletedExceptionally());
    }
}
