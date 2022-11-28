package com.onejava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {
    private int id;
    private String name;
    private int age;
    private int salary;
    private String department;
}
