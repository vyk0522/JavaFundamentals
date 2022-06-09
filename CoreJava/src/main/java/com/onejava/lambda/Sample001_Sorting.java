package com.onejava.lambda;

import com.onejava.dto.User;

import java.util.*;
import java.util.stream.Collectors;

public class Sample001_Sorting {
    public static void main(String[] args) {
        User user1 = new User(1, "VV", 34, 100);
        User user2 = new User(2, "AA", 38, 30);
        User user3 = new User(3, "ZZ", 12, 50);
        User user4 = new User(4, "AA", 23, 40);
        List<User> users = Arrays.asList(user1, user2, user3, user4);

        System.out.println(users);
        users.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));
        System.out.println(users);
        users.sort(Comparator.comparing(User::getName).thenComparing(User::getAge).reversed());
        System.out.println(users);

        Map<String, Integer> map = new HashMap<>();
        map.put("V", 7);
        map.put("A", 8);
        map.put("Z", 9);
        map.put("C", 5);

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::print);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::print);

        Map.Entry<String, Integer> maxEntry = map.entrySet().stream().max(Map.Entry.comparingByKey(String::compareTo)).orElse(null);
        System.out.println("Max Key and Value: " + maxEntry.getKey() + " " + maxEntry.getValue());


        LinkedHashMap<String, Integer> newMap = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(newMap);

        String s = map.keySet().stream().max(String::compareTo).orElse("");
        Integer integer = map.values().stream().max(Integer::compareTo).orElse(0);
        System.out.println(s);
        System.out.println(integer);


    }
}
