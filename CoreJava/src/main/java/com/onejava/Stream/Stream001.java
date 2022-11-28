package com.onejava.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream001 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.forEach(System.out::print); // 1234 Maintains order
        System.out.println();
        list.parallelStream().forEachOrdered(System.out::print); // 1234 Maintains order
        System.out.println();
        list.stream().parallel().forEach(System.out::print); // 3421 Random order
        System.out.println();

        int result = list.stream().filter(e -> e % 2 == 0).mapToInt(e -> e * e).sum();
        System.out.println("Sum: " + result); //20
        System.out.println();

        IntStream ints = IntStream.range(1, 4);  // Primitive ints
        Stream<Integer> stream = ints.boxed();
        List<Integer> list2 = stream.toList();
        System.out.println(list2);

        IntStream ints2 = IntStream.of(1, 2, 3);
        List<Integer> list3 = ints2.mapToObj(e -> e * 2).collect(Collectors.toList());
        System.out.println(list3);

        List<Integer> list4 = Stream.of(1, 2, 3, 4).map(e -> e * 2).toList();
        System.out.println(list4);

        List<Integer> list5 = Stream.iterate(100, e -> e + 2).limit(3).collect(Collectors.toList());
        System.out.println(list5); // 100, 102, 104

        // 1 2 2 3 3 3 4 4 4 4
        IntStream.rangeClosed(1, 4).flatMap(e -> IntStream.iterate(e, i -> i).limit(e)).forEach(System.out::print);



    }
}
