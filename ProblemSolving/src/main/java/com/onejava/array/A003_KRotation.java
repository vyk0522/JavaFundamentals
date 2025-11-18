package com.onejava.array;

import java.util.Arrays;

public class A003_KRotation {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));  // 1, 2, 3, 4, 5

        rotateArrayRight(a, 2);
        System.out.println(Arrays.toString(a)); // 4, 5, 1, 2, 3

        rotateArrayLeft(b, 2);
        System.out.println(Arrays.toString(b)); // 3, 4, 5, 1, 2
    }

    /*
        reverse all
        reverse k elements 0 to k -1
        reverse remaining elements k to length - 1
     */
    private static void rotateArrayRight(int[] a, int k) {
        k = k % a.length;
        reverse(a, 0, a.length - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);

    }

    /*
        reverse k elements 0 to k -1
        reverse remaining elements k to length - 1
        reverse all
     */
    private static void rotateArrayLeft(int[] a, int k) {
        k = k % a.length;
       reverse(a, 0, k-1);
       reverse(a, k, a.length - 1);
       reverse(a, 0, a.length - 1);

    }

    private static void reverse(int[] a, int i, int j){
        while(i < j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
}
