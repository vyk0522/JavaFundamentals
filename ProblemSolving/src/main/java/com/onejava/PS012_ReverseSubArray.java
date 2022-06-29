package com.onejava;


import java.util.Arrays;

public class PS012_ReverseSubArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int l = 2;
        int r = 5;
        reverseSubArray(a, l, r);
        System.out.println(Arrays.toString(a));
    }

    private static void reverseSubArray(int[] a, int l, int r) {
        while(l < r){
            swap(l, r, a);
            l++;
            r--;
        }
    }

    private static void swap(int l, int r, int[] a) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
