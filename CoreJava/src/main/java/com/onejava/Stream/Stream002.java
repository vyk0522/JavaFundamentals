package com.onejava.Stream;

import com.onejava.dto.User;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static com.onejava.dto.UserUtil.getUsers1;
import static java.util.stream.Collectors.*;

public class Stream002 {
    public static void main(String[] args) {
        List<User> users = getUsers1();

        Map<String, List<User>> map1 = users.stream().collect(groupingBy(User::getName));
        System.out.println(map1);

        Map<String, List<Integer>> map2 = users.stream().collect(groupingBy(User::getName, mapping(User::getAge, toList())));
        System.out.println(map2);

        Map<String, Integer> map3 = users.stream().collect(groupingBy(User::getName, mapping(User::getAge, summingInt(e -> e))));
        Map<String, Integer> map31 = users.stream().collect(groupingBy(User::getName, summingInt(User::getAge)));
        Map<String, Long> map32 = users.stream().collect(groupingBy(User::getName, counting()));
        Map<String, IntSummaryStatistics> map33 = users.stream().collect(groupingBy(User::getName, summarizingInt(User::getAge)));
        System.out.println(map3);
        System.out.println(map31);
        System.out.println(map32);
        System.out.println(map33);

        Map<String, String> map4 = users.stream().collect(groupingBy(User::getName, mapping(e -> Integer.toString(e.getAge()), joining(", "))));
        Map<String, String> map41 = users.stream().collect(groupingBy(User::getName, mapping(User::getName, joining(", "))));
        System.out.println(map4);
        System.out.println(map41);

        Map<String, User> deptTopUserMap1 = users.stream().collect(groupingBy(User::getDepartment,
                collectingAndThen(maxBy(Comparator.comparingInt(User::getSalary)), Optional::get)));
        Map<String, User> deptTopUserMap2 = users.stream().collect(toMap(User::getDepartment, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(User::getSalary))));
        System.out.println(deptTopUserMap1);
        System.out.println(deptTopUserMap2);

        Map<Boolean, List<User>> map5 = users.stream().collect(partitioningBy(e -> e.getAge() > 35));
        Map<Boolean, List<String>> map51 = users.stream().collect(partitioningBy(e -> e.getAge() > 35, mapping(User::getName, toList())));
        Map<Boolean, Long> map52 = users.stream().collect(partitioningBy(e -> e.getAge() > 35, counting()));
        System.out.println(map5);
        System.out.println(map51);
        System.out.println(map52);


    }
}

