package com.org;

/*
0,1 are not prime number
Prime Number should have exactly two divisors 1 and Number itself.
 */
public class A001_Prime {
    public static void main(String[] args) {
        System.out.println(isPrime(7)); // true
        System.out.println(isPrime(14)); // false
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {  // condition: i should be less than or equal to square root of n
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
