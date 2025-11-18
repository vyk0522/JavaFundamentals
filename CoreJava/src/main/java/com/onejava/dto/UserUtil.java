package com.onejava.dto;

import java.util.Arrays;
import java.util.List;

public class UserUtil {
    public static List<User> getUsers() {
        User user1 = new User(1, "VV", 34, 100, "IT");
        User user2 = new User(2, "AA", 38, 30, "HR");
        User user3 = new User(3, "ZZ", 12, 50, "IT");
        User user4 = new User(1, "BB", 23, 40, "HR");
        User user5 = new User(1, "CC", 23, 40, "IT");
        return Arrays.asList(user1, user2, user3, user4, user5);
    }

    public static List<User> getUsers1() {
        User user1 = new User(1, "VV", 34, 100, "IT");
        User user2 = new User(2, "AA", 38, 30, "HR");
        User user3 = new User(3, "VV", 12, 50, "IT");
        User user4 = new User(1, "BB", 23, 40, "HR");
        User user5 = new User(1, "AA", 23, 40, "IT");
        User user6 = new User(1, "AA", 23, 40, "ADMIN");
        User user7 = new User(1, "VV", 34, 100, "IT");
        return Arrays.asList(user1, user2, user3, user4, user5, user6, user7);
    }

    public static List<Employee> getEmployees(){
        Address a1 = new Address("Mandya", "Karnataka");
        Address a2 = new Address("Bengaluru", "Karnataka");
        Address a3 = new Address("Mysuru", "Karnataka");
        Address a4 = new Address("Mangalore", "Karnataka");

        Employee employee1 = new Employee(1, "aa", List.of(a1, a3));
        Employee employee2 = new Employee(2, "bb", List.of(a2, a3));
        Employee employee3 = new Employee(3, "cc", List.of(a4, a3));
        Employee employee4 = new Employee(4, "dd", List.of(a4, a3, a1));

        return Arrays.asList(employee1, employee2, employee3, employee4);

    }
}
