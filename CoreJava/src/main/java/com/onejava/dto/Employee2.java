package com.onejava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Employee2 {
    int id;
    String name;
    Address address;
}
