package com.onejava.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.onejava.async.Util.*;
/*
1. To illustrate how chain works when one CF completes exceptionally.
2. When one CF completes exceptionally, remaining chained CFs also completes exceptionally.
3. When CF completes exceptionally, Remaining chained CFs wont get executed at all but completes exceptionally.
 */
public class Sample009 {
    public static void main(String[] args) {
        CompletableFuture<List<Integer>> supply = CompletableFuture.supplyAsync(() -> throwExceptionWhileGettingUserIDs());
        CompletableFuture<List<User>> fetch = supply.thenApply(ids -> getUsers(ids));
        CompletableFuture<Void> display = fetch.thenAccept(users -> displayUsers(users));

        sleep(2500);
        System.out.println("Supply  : done=" + supply.isDone() + " Exception=" + supply.isCompletedExceptionally());
        System.out.println("fetch  : done=" + fetch.isDone() + " Exception=" + fetch.isCompletedExceptionally());
        System.out.println("display  : done=" + display.isDone() + " Exception=" + display.isCompletedExceptionally());
    }
}
