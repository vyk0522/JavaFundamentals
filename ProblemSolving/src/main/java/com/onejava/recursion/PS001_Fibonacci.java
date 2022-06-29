package com.onejava.recursion;

/*
1. Sum of Array Numbers using recursion
2. Fibonacci series using iteration and recursion
Note: Know what is base case or termination case
TC: In each level it calls 2* previous level function calls
ie., 2^0 + 2^1 + 2^2... 2^n-1  > O(2^n)

fib5 - level0 number of calls are 1
fib4  fib3 - level1 number of calls are 2*1
fib3, fib2   fib2, fib1 - level2 number of calls are 2*2
fib2, fib1  fib1, fib0  fib1, fib0

SC: Maximum function calls at any time is N. O(n)

 */
public class PS001_Fibonacci {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println("Sum of Array Using Recursion: " + sumOfArrayNumbers(a, a.length));

        // Using Recursion
        for (int i = 0; i < 9; i++) {
            System.out.print(fibonacci(i) + " "); // 0 1 1 2 3 5 8 13 21
        }

        System.out.println();

        // Using for loop
        for (int i = 0; i < 9; i++) {
            System.out.print(fibonacci2(i) + " "); // 0 1 1 2 3 5 8 13 21
        }

    }

    // f(n) = a[n-1] + f(n-1)
    private static int sumOfArrayNumbers(int[] a, int n){
        // Base case or termination case
        // When n is 0 a[n-1] becomes a[-1] gives AIOBE. So we need to handle this.
        if (n < 1){
            return 0;
        }
        return a[n-1] + sumOfArrayNumbers(a,n-1);  // 4 + 3 + 2 + 1 = 10
    }

    // 0 1 1 2 3 5 8 13 21
    private static int fibonacci(int n){
        if(n <= 1) {
            return n;
        }
        if (n == 2){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibonacci2(int n) {
        int fib1 = 0;
        int fib2 = 1;

        for (int i = 0; i < n; i++) {
            int sum = fib1 + fib2;
            fib1 = fib2;
            fib2 = sum;
        }
        return fib1;
    }
}
