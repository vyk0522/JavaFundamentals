package com.onejava;

import java.util.Arrays;

public class PS015_SegregateOddEven {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        segregateEvenOdd(a);
        System.out.println(Arrays.toString(a));
    }

    /*
     To make it even odd order - Use even check loop first
     To make it odd even order - use odd check loop first
     You will increment i until element is even
     You decrement j until element is odd
     And you will swap
     */
    private static void segregateEvenOdd(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j){
            while (a[i] % 2 == 1 && i < j){
                i++;
            }
            while (a[j] % 2 == 0 && i < j){
                j--;
            }
            if(i < j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

    }
}
