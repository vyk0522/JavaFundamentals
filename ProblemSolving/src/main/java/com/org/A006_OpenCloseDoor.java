package com.org;

public class A006_OpenCloseDoor {
    public static void main(String[] args) {
        openDoors(10);
        System.out.println();
        openDoors(17);
        System.out.println();
        System.out.println("---------------");

        openDoorsUsingPerfectSquare(10);
        System.out.println();
        openDoorsUsingPerfectSquare(17);
    }

    private static void openDoors(int n) {
        boolean[] a = new boolean[n];
        for (int i = 1; i <= a.length; i++) {
            for (int j = i; j <= a.length ; j = j + i) {
                a[j-1] = !a[j-1];
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i]){
                System.out.print(i+1 + " ");
            }
        }
    }


    private static void openDoorsUsingPerfectSquare(int n) {
        for (int i = 1; i <= n; i++) {
            if (perfectSquare(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            if (perfectSquare2(i)){
                System.out.print(i + " ");
            }
        }

    }

    private static boolean perfectSquare(int i) {
        int squareRoot = (int) Math.sqrt(i);
        return squareRoot * squareRoot == i;
    }

    private static boolean perfectSquare2(int i) {
        double sqrt = Math.sqrt(i);
        return Math.ceil(sqrt) == Math.floor(sqrt);
    }
}
