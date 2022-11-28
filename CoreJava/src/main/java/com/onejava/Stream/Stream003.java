package com.onejava.Stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream003 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 2);
        map.put(7, 2);
        map.put(5, 1);
        map.put(10, 4);

        // Sort by value then by key
        // 5,1  3,2  7,2  10,4
        LinkedHashMap<Integer, Integer> result = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(result);

        // Sort by key and then by value does not make sense as key can not be duplicate

    }
}
