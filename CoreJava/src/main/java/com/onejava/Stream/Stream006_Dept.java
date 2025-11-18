package com.onejava.Stream;

import com.onejava.dto.User;
import com.onejava.dto.UserUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream006_Dept {
    public static void main(String[] args) {
        List<User> users = UserUtil.getUsers1();
        /*
        User(id=1, name=VV, age=34, salary=100, department=IT)
        User(id=2, name=AA, age=38, salary=30, department=HR)
        User(id=3, name=VV, age=12, salary=50, department=IT)
        User(id=1, name=BB, age=23, salary=40, department=HR)
        User(id=1, name=AA, age=23, salary=40, department=IT)
         */
        users.forEach(System.out::println);


        /*
        IT - 50, HR - 30
        HR -> User(id=2, name=AA, age=38, salary=30, department=HR)
        IT -> User(id=3, name=VV, age=12, salary=50, department=IT)
         */
        Map<String, Optional<User>> secondHighestSalariedUsers = users.stream().collect(Collectors.groupingBy(User::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparing(User::getSalary).reversed()).skip(1).findFirst())));
        secondHighestSalariedUsers.forEach((dept, user) -> System.out.println(dept + " -> " + user.orElse(null)));

        Map<String, Optional<Integer>> secondHighestSalary = users.stream().collect(Collectors.groupingBy(User::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().map(User::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst())));
        secondHighestSalary.forEach((dept, salary) -> System.out.println(dept + " -> " + salary.orElse(null)));


    }
}
