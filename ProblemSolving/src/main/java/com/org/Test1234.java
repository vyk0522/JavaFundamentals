package com.org;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1234 {
    public static void main(String[] args) {
        Integer[] a = {25, 2, 3, 57, 38, 41};
        System.out.println(Arrays.toString(solution(a)));

    }

    private static List<Integer> digits(Integer number){
        List<Integer> result = new ArrayList<>();
        String str = Integer.toString(number);
        for (int i = 0; i < str.length(); i++) {
            int i1 = Integer.parseInt("" + str.charAt(i));
            result.add(i1);
        }
        return result;
    }

    private static Integer[] solution(Integer[] a) {
        Map<Integer, Integer> map = Arrays
                .stream(a)
                .map(e -> digits(e))
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));

        int maxVal = Collections.max(map.values());
        Set<Integer> set = new TreeSet<>();
        map.entrySet().forEach(e -> {
            if (e.getValue().equals(maxVal)){
                set.add(e.getKey());
            }
        });

        return set.toArray(Integer[]::new);

    }
}
