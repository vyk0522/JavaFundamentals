package com.onejava.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.onejava.async.Util.*;

/*
1. Fetching Users 2 completes first as it takes lesser time. And whichever is completed first is consumed in acceptEither()
2.  If both CompletableFuture is completed at the time of invoking acceptEither().
 It accepts/consumes users1 result if users1.acceptEither(users2, ..);
 It accepts/consumes users2 result if users2.acceptEither(users1, ..);
    Users 2 is completed
    Users 1 is completed
    user{4,5,6}
 */
public class Sample008 {
    public static void main(String[] args) {
        Supplier<List<Integer>> getUserIds1 = () -> Arrays.asList(1,2,3);
        Supplier<List<Integer>> getUserIds2 = () -> Arrays.asList(4,5,6);
        Function<List<Integer>, CompletableFuture<List<User>>> fetchUsers1 = (ids) -> getUsers1(ids) ; // it takes 1000ms
        Function<List<Integer>, CompletableFuture<List<User>>> fetchUsers2 = (ids) -> getUsers2(ids); // it takes 700ms
        Consumer<List<User>> displayUsers = users -> users.forEach(System.out::println);

        CompletableFuture<List<Integer>> completableFuture1 = CompletableFuture.supplyAsync(getUserIds1); // CF it supplies users ids 1
        CompletableFuture<List<Integer>> completableFuture2 = CompletableFuture.supplyAsync(getUserIds2); // CF it supplies users ids 2
        CompletableFuture<List<User>> users1 = completableFuture1.thenComposeAsync(fetchUsers1);
        CompletableFuture<List<User>> users2 = completableFuture2.thenComposeAsync(fetchUsers2);

        users1.thenRun(() -> System.out.println("Users 1 is completed"));
        users2.thenRun(() -> System.out.println("Users 2 is completed"));
       // sleep(2000);   // Uncomment this so that main thread waits to complete both the tasks.
        // If both CompletableFuture is completed at this time, it accepts users1 result because of users1.acceptEither(users2...
        // Else, it accepts which ever is completed at this time.
        users2.acceptEither(users1, displayUsers);
        sleep(2000);
    }
}
