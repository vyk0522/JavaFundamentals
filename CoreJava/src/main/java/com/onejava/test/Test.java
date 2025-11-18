package com.onejava.test;

public class Test {
    public static void main(String[] args) {
        Add add = (i, j) -> i+j;
        int sum = add.add(2, 3);
        System.out.println(sum);

        SayHello sayHello = () -> System.out.println("Hello World!!");
        sayHello.hello();

    }
}

interface Add{
    int add(int i, int j);
}

interface SayHello{
    void hello();
}
