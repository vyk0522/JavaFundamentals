package com.onejava.recursion;
/*
1. Factorial of number using iteration and recursion
 */
public class PS008_Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(3)); // 3*2 = 6
        System.out.println(factorial(5)); // 5*4*3*2 = 120

        System.out.println(factorial2(5)); // 5*4*3*2 = 120
    }

    // Using iteration
    private static int factorial(int n){
        int result = 1;
        for (int i = n; i > 1; i--){
            result = result * i;
        }
        return result;
    }

    // Using recursion
    private static int factorial2(int n){
        if(n <= 2){
            return n;
        }
        return n * factorial(n-1);
    }
}
