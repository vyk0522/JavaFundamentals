package com.onejava.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream001 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        compute(integers);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> elementPairList = numbers.stream()
                .map(Stream001::elementPairs).flatMap(Collection::stream).toList();
        System.out.println(elementPairList); // [0, 2, 1, 3, 2, 4, 3, 5]

        System.out.println(printPattern()); // [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]

    }

    public static void compute(List<Integer> list){
        // Double each element
        List<Integer> doubledElements = list.stream().map(e -> e * e).collect(Collectors.toList());
        System.out.println(doubledElements);

        // Double the even numbers and sum it -> 20
        int sum = list.stream().filter(e -> e % 2 == 0).mapToInt(e -> e * e).sum();
        System.out.println(sum);
    }

    // It returns list of previous number and next number of given number
    public static List<Integer> elementPairs(Integer element){
        return List.of(element - 1, element + 1);
    }

    // [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]
    public static List<Integer> printPattern(){
        return IntStream.rangeClosed(1, 4)
                .flatMap(e -> IntStream.iterate(e, IntUnaryOperator.identity()).limit(e))
                .boxed()
                .toList();
    }

    public static List<Integer> printString(String input){
        return IntStream.rangeClosed(1, 4)
                .flatMap(e -> IntStream.iterate(e, IntUnaryOperator.identity()).limit(e))
                .boxed()
                .toList();
    }



}
