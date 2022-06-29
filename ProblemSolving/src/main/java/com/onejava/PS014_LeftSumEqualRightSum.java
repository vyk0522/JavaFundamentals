package com.onejava;

public class PS014_LeftSumEqualRightSum {
    public static void main(String[] args) {
        int[] a = {-7, 1, 5, 2, -4, 3, 0};
        int[] b = {9, 3, 7, 6, 8, 1, 10};
        System.out.println(equilibriumIndex(a));
        System.out.println(equilibriumIndex(b));
    }

    private static int equilibriumIndex(int[] a){
        int leftSum = 0;
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }

        for (int i = 0; i < a.length; i++) {
            sum = sum - a[i]; // right sum

            if (leftSum == sum){
                return i;
            }
            leftSum = leftSum + a[i];
        }
        return -1;
    }
}
