package com.org;

/*
App1 : Sort the array. if difference between number is more than 1, that element is missing O(nlogn)
App2 : store the number in that index.. Which ever index has missing value, that number is missing  O(n) extra space
 */
public class A002_MissingNumberInArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6};
        int[] b = {1, 2, 3, 4, 5};
        int[] c = {4, 2, 1, 2, 1, 4, 5, 3, 5};

        System.out.println(missingNumber(a)); //4
        System.out.println(missingNumberUsingFormula(a)); //4
        System.out.println(missingNumber(b)); //6

        System.out.println(oneTimeOccurredNumber(c)); //3
    }

    private static int missingNumber(int[] a){
        int result = 0; // 0 xor A gives A
        for (int i : a) {
            result = result ^ i;
        }
        for (int i = 1; i <= a.length + 1; i++) {
            result = result ^ i;
        }
        return result;
    }

    // But we cannot use with big sum
    private static int missingNumberUsingFormula(int[] a){
        int n = a.length + 1;
        int total =n * (n + 1) / 2;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return total - sum;
    }

    private static int oneTimeOccurredNumber(int[] a){
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result ^ a[i];
        }
        return result;
    }
}
