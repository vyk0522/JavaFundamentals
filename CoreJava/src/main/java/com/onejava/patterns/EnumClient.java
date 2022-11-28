package com.onejava.patterns;

import com.onejava.dto.Status;

import java.util.Arrays;

public class EnumClient {
    public static void main(String[] args) {
        Status status = Status.NOT_STARTED;
        System.out.println(status); // NOT_STARTED
        System.out.println(status.getStatusValue()); // 0
        System.out.println(Arrays.toString(Status.values())); // [NOT_STARTED, IN_PROGRESS, UNDER_REVIEW, COMPLETED]

        status.m1();
        Status.IN_PROGRESS.m1();

        Arrays.stream(Status.values()).map(Status::getStatusValue).forEach(System.out::print);
    }
}
