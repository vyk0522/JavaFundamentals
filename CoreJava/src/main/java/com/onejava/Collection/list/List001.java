package com.onejava.Collection.list;

import java.util.*;

/*
1. To illustrate iterator
 */
public class List001 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        System.out.println(">> iteratorExample >>");
        iteratorExample(list);
        System.out.println();

        System.out.println(">> concurrentModificationExceptionExample >>");
        concurrentModificationExceptionExample(list);

        System.out.println(">> forEachRemainingExample >>");
        forEachRemainingExample(list);
        System.out.println();

        System.out.println(">> listIteratorExample >>");
        listIteratorExample(list);

    }

    private static void listIteratorExample(List<String> list) {
        ListIterator<String> iterator = list.listIterator(2);
        while (iterator.hasPrevious()){
            System.out.print(iterator.previous() + " ");
        }
    }

    private static void forEachRemainingExample(List<String> list) {
        Iterator<String> iterator = list.iterator();
        iterator.forEachRemaining(s -> System.out.print(s + " "));
    }

    private static void concurrentModificationExceptionExample(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String value = iterator.next();
            System.out.println(value);
            // list.add("four"); // ConcurrentModificationException
            // list.remove("one"); // ConcurrentModificationException
            //iterator.remove(); // IllegalStateException when we call remove() without calling next()
            if ("two".equals(value)) {
                iterator.remove(); // to safely remove returned element by next()
            }
        }
        System.out.println(list); // [one, three]
    }

    private static void iteratorExample(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
}
