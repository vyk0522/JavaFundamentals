package com.onejava;

/*
Sub-array of size k, find max sum of sub-array
 */
public class PS002_FixedSlidingWindow {

    public static void main(String[] args) {
        System.out.println(maxSumOfKLengthSubstring(new int[]{2, 5, 1, 8, 2, 9, 1}, 3));

    }

    /*
    When window size is not of k, Just sum the elements and increment j
    When Window size becomes k, we need to store their sum, move i's and j's position and take sum again...
     */
    public static int maxSumOfKLengthSubstring(int[] a, int k) {
        int i = 0;
        int j = 0;
        int result = 0;
        int sum = 0;

        while(j < a.length){
            if(j-i+1 < k){
                sum = sum + a[j];
            } else {
                sum = sum + a[j];
                result = Math.max(result, sum);
                sum = sum - a[i];
                i++;
            }
            j++;
        }
        return result;
    }

    public static int sumAtEndElements(int[] a, int k) {
        int sum = 0;
        int j = a.length - 1;
        int max = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + a[i];
        }
        while(k > 0){
            sum = sum - a[k-1] + a[j];
            j--;
            k--;
            max = Math.max(max, sum);
        }
        return max;
    }


}
