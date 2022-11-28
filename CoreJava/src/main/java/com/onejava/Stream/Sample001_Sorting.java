package com.onejava.Stream;

import com.onejava.dto.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.onejava.dto.UserUtil.getUsers;

public class Sample001_Sorting {
    public static void main(String[] args) {
        List<User> users = getUsers();

        // remove duplicates
        List<User> users1 = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity(), (u1, u2) -> u2))
                .values().stream().toList();
        System.out.println("users1: " + users1);


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
