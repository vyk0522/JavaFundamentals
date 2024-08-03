package com.onejava.array;

import java.util.Arrays;

public class A002_FewCoinToMakeSum {
    public static void main(String[] args) {
        //System.out.println(coinChange(new int[]{1, 2,5}, 11));
        //System.out.println(coinChange(new int[]{2,5}, 3));
        System.out.println(coinChange(new int[]{1, 3, 4, 5}, 7));

    }

    public static int coinChange(int[] coins, int amount) {
        int[] a = new int[amount + 1];
        Arrays.fill(a, amount + 1);
        a[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    a[i] = Math.min(a[i], a[i - coins[j]] + 1);
                }
            }
        }
        return a[amount] > amount ? -1 : a[amount];
    }
}
