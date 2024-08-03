package com.onejava.maths;

public class PS001_SwapTwoNumbersWithoutTemp {
    public static void main(String[] args) {
        swapNumbers(100, 300);
        swapNumbersUsingXor(100, 300);
    }

    private static void swapNumbers(int x, int y){
        System.out.println("Before Swapping: X: " + x + ", Y: " + y);
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("After Swapping: X: " + x + ", Y: " + y);
    }

    private static void swapNumbersUsingXor(int x, int y){
        System.out.println("Before: X: " + x + ", Y: " + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After: X: " + x + ", Y: " + y);
    }
}
