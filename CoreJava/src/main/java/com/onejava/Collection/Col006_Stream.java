package com.onejava.Collection;

import com.onejava.dto.User;
import com.onejava.dto.UserUtil;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;

public class Col006_Stream {
    public static void main(String[] args) {
        List<User> users = UserUtil.getUsers();
        Map<User, Integer> map = users.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(User::getAge)));
        System.out.println(map);

        Map<String, String> collect = users.stream().collect(Collectors.groupingBy(User::getName, mapping(user -> Integer.toString(user.getAge()), joining(", "))));
        System.out.println(collect);

    }
}
