package com.onejava.Stream;

import com.onejava.dto.Employee;
import com.onejava.dto.UserUtil;

import java.util.List;

public class Stream004_FilterByAddress {
    public static void main(String[] args) {
        List<Employee> employees = UserUtil.getEmployees();

        List<Employee> byCity = employees.stream()
                .filter(e -> e.getAddresses().stream().anyMatch(address -> address.getCity().equals("Mandya")))
                .toList();

        System.out.println(byCity);
        System.out.println(byCity.size());
    }
}
