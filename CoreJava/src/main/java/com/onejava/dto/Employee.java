package com.onejava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Employee {
    int id;
    String name;
    List<Address> addresses;
}
