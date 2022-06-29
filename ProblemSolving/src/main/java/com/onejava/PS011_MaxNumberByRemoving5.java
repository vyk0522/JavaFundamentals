package com.onejava;

public class PS011_MaxNumberByRemoving5 {
    public static void main(String[] args) {
        int n1 = 15958; // 1958
        int n2 = -5859; // -589
        int n3 = -5000; // 0
        int n4 = 2535675;
        System.out.println(maxNumberByRemoving5(n1));
        System.out.println(maxNumberByRemoving5(n2));
        System.out.println(maxNumberByRemoving5(n3));
        System.out.println(maxNumberByRemoving5(n4));
    }

    private static int maxNumberByRemoving5(int n) {
        String s1 = Integer.toString(n);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '5') {
                String s2 = s1.substring(0, i).concat(s1.substring(i + 1));
                max = Math.max(max, Integer.parseInt(s2));
            }

        }
        return max;
    }
}
