package com.onejava.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.onejava.async.Util.*;

/*
1. Task1 - Fetches list of user IDs from remote service - Long running task - so run it asynchronously
2. Task2 - Fetches user objects using userIDs from DB - Long running task - so run it asynchronously
3. Task3 - Fetches email objects using userIDs from DB - Long running task - so run it asynchronously
4. To accept/consume both CompletableFutures
 */
public class Sample007 {
    public static void main(String[] args) {
        Supplier<List<Integer>> userIdsSupplier = () -> getUserIDs();
        // Fetching the user objects Asynchronously.
        Function<List<Integer>, CompletableFuture<List<User>>> fetchUsers = ids -> getUsersAsync(ids);
        // Fetching the Email objects Asynchronously.
        Function<List<Integer>, CompletableFuture<List<Email>>> fetchEmails = ids -> getEmailsAsync(ids);

        CompletableFuture<List<Integer>> completableFuture = CompletableFuture.supplyAsync(userIdsSupplier);
        CompletableFuture<List<User>> usersCompletableFuture = completableFuture.thenCompose(fetchUsers);
        CompletableFuture<List<Email>> emailsCompletableFuture = completableFuture.thenCompose(fetchEmails);

        // this CF which completes on the completion of both usersCompletableFuture and emailsCompletableFuture
        CompletableFuture<Void> completableFuture1 = usersCompletableFuture.thenAcceptBoth(emailsCompletableFuture,
                (users, emails) -> System.out.println(users.size() + " - " + emails.size()));
        sleep(4000);
    }
}