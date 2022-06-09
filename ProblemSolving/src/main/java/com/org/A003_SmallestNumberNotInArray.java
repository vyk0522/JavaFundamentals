package com.org;

import java.util.Arrays;

/*
that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
Given A = [1, 2, 3], the function should return 4.
Given A = [−1, −3], the function should return 1.
 */
public class A003_SmallestNumberNotInArray {
    public static void main(String[] args) {
        int[] a = {1, 3, 6, 4, 1, 2}; // 5
        int[] b = {1, 2, 3}; // 4
        int[] c = {-1, -3}; // 1

        System.out.println(smallestNumber(a));
        System.out.println(smallestNumber(b));
        System.out.println(smallestNumber(c));

    }

    private static int smallestNumber(int[] a) {
        int result = 1;
        Arrays.sort(a); // 1, 1, 2, 3, 4, 6
        for (int i = 0; i < a.length; i++) {
            if (a[i] == result){
                result = result + 1;
            }
        }
        return result;
    }
}
