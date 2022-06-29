package com.onejava.async;

import java.util.concurrent.CompletableFuture;

import static com.onejava.async.Util.*;

/*
1. To illustrate how main method keeps on waiting, If we don't complete delayed completableFuture explicitly and try to
get the result of completableFuture using join() -- Comment complete()
 */
public class Sample005 {
    public static void main(String[] args) {
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        Runnable task = () -> dummy("Dummy 1 by: ");
        CompletableFuture.runAsync(task);

        completableFuture.complete(null);
        Void nil = completableFuture.join();
        System.out.println(nil); // null
        System.out.println("We are done!!");
        sleep(200); // task CompletableFuture takes 200MS, so calling sleep on main thread to see the output of task CF.
    }
}
