package com.onejava.Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Matrix {
    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2, 1}, {2, 5, 3}, {3, 4, 6}, {6, 1, 4}};
        System.out.println(getCount(matrix));
    }

    private static long getCount(Integer[][] matrix) {
        return Arrays
                .stream(matrix)
                .map(Matrix::getElements)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)))
                .values()
                .stream()
                .filter(e -> e > 1)
                .count();
    }

    private static Set<Integer> getElements(Integer[] integers) {
        return new HashSet<>(Arrays.asList(integers));
    }
}