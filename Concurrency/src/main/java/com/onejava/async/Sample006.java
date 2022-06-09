package com.onejava.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.onejava.async.Util.*;

/*
1. Task1 - Fetches list of user IDs from remote service - Long running task - so run it asynchronously
2. Task2 - Fetches user objects from DB - Long running task - so run it asynchronously
3. To illustrate usage of thenCompose() method when thenApply() returns CompletableFuture wrapped in CompletableFuture instead of
returning data wrapped in CompletableFuture.
4. Usually thenApply() returns data wrapped in CompletableFuture but in this example it is returning
CompletableFuture wrapped in CompletableFuture, so using thenCompose()
 */
public class Sample006 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Supplier<List<Integer>> userIDsSupplier = () -> getUserIDs();
        Function<List<Integer>, CompletableFuture<List<User>>> fetchUsers = ids -> getUsersAsync(ids);
        Consumer<List<User>> displayer = list -> displayUsers(list);

        CompletableFuture<List<Integer>> completableFuture = CompletableFuture.supplyAsync(userIDsSupplier);
        // Fetching the user objects Asynchronously.
        completableFuture.thenCompose(fetchUsers).thenAcceptAsync(displayer,executor);
        sleep(4000);
        executor.shutdown();

/*
        // Fetching the user objects is synchronous process. It is conducted synchronously when list of user IDs are available
        Function<List<Integer>, List<User>> usersFunction1 = ids -> fetchFromDB(ids);
        Consumer<List<User>> displayer1 = list -> displayUsers(list);
        CompletableFuture<List<Integer>> completableFuture1 = CompletableFuture.supplyAsync(userIdsSupplier);
        completableFuture1.thenApply(usersFunction1)
                                .thenAcceptAsync(displayer1, executor);
*/

    }
}
