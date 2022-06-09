package com.onejava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private long salary;
}
