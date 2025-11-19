package com.onejava.string;

public class S001_SwapTwoVarsWithoutTempVar {
    public static void main(String[] args) {
        swapStrings();
        swapNumbers();
        swapNumbersXOR();
    }

    private static void swapStrings() {
        String s1 = "Hello";
        String s2 = "World";

        s1 = s1 + s2;  // HelloWorld
        int index = s1.indexOf(s2);
        s2 = s1.substring(0, index);
        s1 = s1.substring(index);

        System.out.println("New S1: " + s1); // World
        System.out.println("New S2: " + s2); // Hello
    }

    private static void swapNumbers() {
        int a = 10;
        int b = 20;

        a = a + b; // 30
        b = a - b; // 30 - 20 = 10
        a = a - b; // 30 - 10 = 20

        System.out.println("New a: " + a); // 20
        System.out.println("New b: " + b); // 10
    }

    private static void swapNumbersXOR() {
        int x = 10;
        int y = 20;

        x = x ^ y;  // 10 ^ 20
        y = x ^ y;  // 10 ^ 20 ^ 20 = 10
        x = x ^ y;  // 10 ^ 20 ^ 10 = 20

        System.out.println("New x: " + x); // 20
        System.out.println("New y: " + y); // 10
    }
}
