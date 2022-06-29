package com.onejava.async;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static com.onejava.async.Util.sleep;
/*
1. To illustrate the usage of thenCompose() and thenCombine()
2. thenCompose() is used when function returns CompletableFuture wrapped in CompletableFuture instead of
returning data wrapped in CompletableFuture.
3. thenCombine() combines results of two CompletableFutures.
 */
public class Sample015 {
    public static void main(String[] args) {
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> 5);
        Function<Integer, CompletableFuture<Integer>> function1 = i -> CompletableFuture.supplyAsync(() -> 10);
        Function<Integer, Integer> function2 = i -> i;

        CompletableFuture<Integer> completableFuture2 = completableFuture1.thenCompose(function1);
        CompletableFuture<Integer> completableFuture3 = completableFuture1.thenApply(function2);

        CompletableFuture<Integer> completableFuture4 = CompletableFuture.supplyAsync(() -> 15);

        completableFuture2
                .thenCombine(completableFuture3, Integer::sum)
                .thenCombine(completableFuture4, (result1, result2) -> result1 + result2)
                .thenAccept(e -> System.out.println(e)); //30
        sleep(200);
    }
}
