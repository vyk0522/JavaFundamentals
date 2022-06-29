package com.onejava.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/*
1. To have util methods
2. All methods returns or consumes only data not CompletableFuture
3. Here sleep() indicates, the method takes that much time to execute that task
 */
public class Util {
    public static void dummy(String s) {
        sleep(200);
        System.out.println(s + Thread.currentThread().getName());
    }

    public static void logMessage() {
        sleep(100);
        System.out.println("Executing logMessage() by: " + Thread.currentThread().getName());
        System.out.println("Users Has been read!");
    }

    public static void displayUsers(List<User> users) {
        sleep(500);
        System.out.println("Executing displayUsers() by: " + Thread.currentThread().getName());
        users.forEach(System.out::println);
    }

    public static List<User> getUsers(List<Integer> ids) {
        sleep(1000);
        System.out.println("Executing getUsers() by: " + Thread.currentThread().getName());
        return ids.stream().map(User::new).collect(Collectors.toList());
    }

    public static List<Integer> throwExceptionWhileGettingUserIDs() {
        sleep(500);
        System.out.println("Executing throwExceptionWhileGettingUserIDs() by: " + Thread.currentThread().getName());
        throw new IllegalStateException("No data");
    }

    // Long running task - so running it asynchronously
    public static CompletableFuture<List<User>> getUsersAsync(List<Integer> ids) {
        System.out.println("Executing getUsersAsync() by: " + Thread.currentThread().getName());
        sleep(900);
        Supplier<List<User>> userObjectSupplier = () -> ids.stream().map(User::new).collect(Collectors.toList());
        return CompletableFuture.supplyAsync(userObjectSupplier);
    }

    public static CompletableFuture<List<User>> getUsers1(List<Integer> ids) {
        System.out.println("Executing getUsers1() by: " + Thread.currentThread().getName());
        sleep(1000);
        Supplier<List<User>> userObjectSupplier = () -> ids.stream().map(User::new).collect(Collectors.toList());
        return CompletableFuture.supplyAsync(userObjectSupplier);
    }

    public static CompletableFuture<List<User>> getUsers2(List<Integer> ids) {
        System.out.println("Executing getUsers2() by: " + Thread.currentThread().getName());
        sleep(700);
        Supplier<List<User>> userObjectSupplier = () -> ids.stream().map(User::new).collect(Collectors.toList());
        return CompletableFuture.supplyAsync(userObjectSupplier);
    }

    // Long running task - so running it asynchronously
    public static CompletableFuture<List<Email>> getEmailsAsync(List<Integer> ids) {
        System.out.println("Executing getEmailsAsync() by: " + Thread.currentThread().getName());
        sleep(900);
        Supplier<List<Email>> emailObjectSupplier = () -> ids.stream().map(Email::new).collect(Collectors.toList());
        return CompletableFuture.supplyAsync(emailObjectSupplier);
    }

    public static List<Integer> getUserIDs() {
        sleep(500);
        System.out.println("Executing getUserIDs() by: " + Thread.currentThread().getName());
        return Arrays.asList(1,2,3);
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getThreadName() {
        sleep(1000);
        return Thread.currentThread().getName();
    }

    public static void testTheResult(List<Integer> list, Throwable exception) {
        if (list == null) {
            System.out.println("An exception has been raised");
        }
        else{
            System.out.println("Users has been read");
        }
    }

    public static List<Integer> handleTheResult(List<Integer> list, Throwable exception) {
        if(list != null){
            return list;
        }
        else{
            System.out.println("An Exception has been raised");
            return Arrays.asList(99);
        }
    }
}
