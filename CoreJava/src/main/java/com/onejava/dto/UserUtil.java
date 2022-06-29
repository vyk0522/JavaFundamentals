package com.onejava.dto;

import java.util.Arrays;
import java.util.List;

public class UserUtil {
    public static List<User> getUsers() {
        User user1 = new User(1, "VV", 34, 100);
        User user2 = new User(2, "AA", 38, 30);
        User user3 = new User(3, "ZZ", 12, 50);
        User user4 = new User(1, "BB", 23, 40);
        User user5 = new User(1, "CC", 23, 40);
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);
        return users;
    }
}
