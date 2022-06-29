package com.onejava.string;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/*
1. To Sort a String
2. To reverse a String
3. StringJoiner
4. Regex
 */
public class String001 {
    public static void main(String[] args) {
        String input = "hello";
        String sortedString1 = sortString(input);
        String sortedString2 = sortString2(input);
        System.out.println(sortedString1); // ehllo
        System.out.println(sortedString2); // ehllo

        String reversedString = new StringBuilder(input).reverse().toString();
        System.out.println(reversedString); // olleh

        StringJoiner sj = new StringJoiner(", ");
        sj.add("alpha").add("beta").add("gamma");
        String sjResult = sj.toString();
        System.out.println(sjResult); // alpha, beta, gamma

        StringJoiner sj1 = new StringJoiner(", ", "{", "}");
        sj1.add("alpha").add("beta").add("gamma");
        System.out.println(sj1); // {alpha, beta, gamma}

        StringJoiner sj2 = new StringJoiner("], [", "[", "]");
        sj2.add("alpha").add("beta").add("gamma");
        System.out.println(sj2); // [alpha], [beta], [gamma]

        StringJoiner sj3 = new StringJoiner(", ", "{", "}");
        sj3.setEmptyValue("Empty"); // To display default value when add is never called
        System.out.println(sj3); // {} .. if no prefix and suffix it shows blank.

        String s1 = "abc Abc 077&";
        // It replaces characters which is not UpperCase, LowerCase and Digits with blank
        s1 = s1.replaceAll("[^A-Za-z0-9]", ""); // abcAbc077
        s1 = s1.replaceFirst("[^A-Z]", ""); // It replaces first character alone
        System.out.println(s1);

        String s2 = "apple mango and orange please  ";
        String[] parts = s2.split(" ");
        System.out.println(Arrays.toString(parts)); // [apple, mango, and, orange, please]
        System.out.println(parts.length); // 5

        String s3 = "  ";
        System.out.println(s3.isBlank()); // true
        System.out.println(s3.isEmpty()); // false

        String s4 = "abcdef";
        String substring = s4.substring(1);
        String substring1 = s4.substring(1, 3); // (Inclusive, Exclusive)
        System.out.println(substring); // bcdef
        System.out.println(substring1); // bc

        String s5 = "abc";
        System.out.println("V: " + s5.substring(0, 3)); // You can use range within size

    }

    private static String sortString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static String sortString2(String input) {
        return Arrays.stream(input.split("")).sorted().collect(Collectors.joining());
    }
}
