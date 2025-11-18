package com.onejava.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream001 {
    public static void main(String[] args) {

        int sum = Stream.of(1, 2, 3, 4).filter(e -> e % 2 == 0).mapToInt(e -> e * e).sum();
        System.out.println("Sum Is: " + sum); // 4 + 16 = 20

        String elementStr = Stream.of("aa", "bb", "cc", null, 1).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Element string is: " + elementStr);  // aa, bb, cc, 1

        String str = "ZZ AA BB CC AA BB ZZ AA";
        List<String> uniqueSortedWords = Stream.of(str.split(" ")).distinct().sorted().toList();
        System.out.println("uniqueSortedWords: " + uniqueSortedWords);

        int[] a = {1, 2, 3, 4};
        Arrays.stream(a).boxed().filter(e -> e % 2 != 0).forEach(System.out::print);
        System.out.println();

        System.out.print("Odd numbers: ");
        Stream.iterate(1, e -> e + 2).limit(5).forEach(System.out::print); // 13579
        System.out.println();
        String joinedOddNumbers = Stream.iterate(1, e -> e + 2).limit(5).map(e -> Integer.toString(e)).collect(Collectors.joining(", "));
        System.out.println("JoinedOddNumbers: " + joinedOddNumbers); // 1, 3, 5, 7, 9

        String pattern = IntStream.rangeClosed(1, 4).flatMap(e -> IntStream.iterate(e, IntUnaryOperator.identity()).limit(e))
                .mapToObj(Integer::toString).collect(Collectors.joining(", "));
        System.out.println("Pattern: " + pattern); // 1, 2, 2, 3, 3, 3, 4, 4, 4, 4

        IntStream.rangeClosed(1, 4).boxed().flatMap(e -> Stream.iterate(e, UnaryOperator.identity()).limit(e)).forEach(System.out::print);
        System.out.println();


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
        IntStream ints21 = IntStream.of(1, 2, 3);
        List<Integer> list3 = ints2.mapToObj(e -> e * 2).collect(Collectors.toList());
        List<Integer> list31 = ints21.boxed().collect(Collectors.toList());
        System.out.println(list3);
        System.out.println(list31);

        Stream.iterate(2, e -> e + 2).limit(10).forEach(System.out::print);

        List<Integer> list4 = Stream.of(1, 2, 3, 4).map(e -> e * 2).toList();
        System.out.println(list4);

        List<Integer> list5 = Stream.iterate(100, e -> e + 2).limit(3).collect(Collectors.toList());
        System.out.println(list5); // 100, 102, 104
        List<Integer> list51 = Stream.iterate(100, e -> e + 1).limit(5).collect(Collectors.toList());
        System.out.println(list51);

        // 1 2 2 3 3 3 4 4 4 4
        IntStream.rangeClosed(1, 4).flatMap(e -> IntStream.iterate(e, i -> i).limit(e)).forEach(System.out::print);




    }
}
