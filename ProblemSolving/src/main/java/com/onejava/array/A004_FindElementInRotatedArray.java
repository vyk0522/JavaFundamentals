package com.onejava.array;

public class A004_FindElementInRotatedArray {
    public static void main(String[] args) {
        // 0, 1, 2, 4, 5, 6, 7
        // 4, 5, 6, 7, 0, 1, 2
        int[] a = {0,1,2,4,5,6,7};
        System.out.println(binarySearch(a, 4)); // 3

        int[] b = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchInRotatedArray(b, 4)); // 0

        System.out.println(searchPivotIndex(a)); // 0
        System.out.println(searchPivotIndex(b)); // 4

    }

    private static int binarySearch(int[] a, int k){
        int i = 0;
        int j = a.length - 1;

        while (i <= j){
            int mid = (i + j) / 2;

            if(a[mid] == k){
                return mid;
            }

            if(k > a[mid]){
                i = mid + 1;
            }
            else{
                j = mid - 1;
            }
        }

        return -1;
    }

    // Search an element k in a rotated sorted array a[]
    private static int searchInRotatedArray(int[] a, int k) {

        int i = 0;
        int j = a.length - 1;

        while (i <= j) {

            int mid = (i + j) / 2;

            // Case 1: Found the element
            if (a[mid] == k) {
                return mid;
            }

            // Case 2: Determine which half is sorted

            // LEFT HALF is sorted (from i to mid)
            if (a[i] <= a[mid]) {

                // Check if k lies inside the sorted LEFT half
                if (k >= a[i] && k < a[mid]) {
                    j = mid - 1;   // search in left half
                } else {
                    i = mid + 1;   // search in right half
                }

            }
            // RIGHT HALF is sorted (from mid to j)
            else {

                // Check if k lies inside the sorted RIGHT half
                if (k > a[mid] && k <= a[j]) {
                    i = mid + 1;   // search in right half
                } else {
                    j = mid - 1;   // search in left half
                }
            }
        }

        // Element not found
        return -1;
    }

    private static int searchPivotIndex(int[] a) {
        int i = 0;
        int j = a.length - 1;

        // Case 1: Array is NOT rotated (already sorted)
        if (a[i] <= a[j]) {
            return 0;
        }

        while (i <= j) {
            int mid = (i + j) / 2;

            // Case 2: mid is pivot
            if (mid > 0 && a[mid] < a[mid - 1]) {
                return mid;
            }

            // Case 3: mid+1 is pivot
            if (mid < j && a[mid] > a[mid + 1]) {
                return mid + 1;
            }

            // Case 4: Decide side — left half is sorted
            if (a[i] <= a[mid]) {
                i = mid + 1;  // pivot is in right half
            }
            else {
                j = mid - 1;  // pivot is in left half
            }
        }

        return 0; // fallback (should rarely hit)
    }
}
