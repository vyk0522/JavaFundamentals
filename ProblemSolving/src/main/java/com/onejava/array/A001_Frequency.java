package com.onejava.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    1. Frequency of Lower chars
    2. Frequency of All chars
    3. Frequency using Hashmap V1 and V2
    3. First Unique Character
    4. Ascii value of Numbers, UpperCase and LowerCase letters
 */
public class A001_Frequency {
    public static void main(String[] args) {
        char[] lowerChars = "aabbccc".toCharArray();
        printFrequencyOfLowerChars(lowerChars);

        char[] widerRangeChars = "Hello world".toCharArray();
        printFrequencyOf256Chars(widerRangeChars);

        printFrequencyUsingHashMap("aabbccc");
        printFrequencyUsingHashMap(Arrays.asList(1, 1, 2, 2, 3, 3, 3));

        char[] chars = "VivekV".toCharArray();
        System.out.println("First Unique Char: " + firstUniqueCharacter(chars)); // i

        // 0= 48, 1= 49, 9= 57, A= 65, Z= 90, a= 97, z= 122,
        printAscii("019AZaz".toCharArray());

    }

    private static void printFrequencyOfLowerChars(char[] chars){
        int[] frequency = new int[26];

        for (int i = 0; i < chars.length; i++) {
            frequency[chars[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                System.out.println("[" + (char)(i + 'a') + "] = " + frequency[i]);
            }
        }

    }

    //   = 1, H = 1, d = 1, e = 1, l = 3, o = 2, r = 1, w = 1,
    private static void printFrequencyOf256Chars(char[] chars) {
        int[] frequency = new int[256];

        for (int i = 0; i < chars.length; i++) {
            frequency[chars[i]]++;
        }

        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                System.out.print((char)(i) + " = " + frequency[i] + ", ");
            }
        }
    }

    private static void printFrequencyUsingHashMap(String input){
        Map<Character, Integer> map = input
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        System.out.println(map);
    }

    private static <X> Map<X, Integer> printFrequencyUsingHashMap(List<X> elements) {
        Map<X, Integer> map = new HashMap<>();
        for(X element : elements){
            Integer frequency = map.get(element);
            frequency = frequency == null ? 1 : ++frequency;
            map.put(element, frequency);
        }
        System.out.println(map);
        return map;
    }

    private static Character firstUniqueCharacter(char[] chars){
        int[] frequency = new int[256];

        for (int i = 0; i < chars.length; i++) {
            frequency[chars[i]]++;
        }

        for (Character c: chars) {
            if(frequency[c] == 1){
                return c;
            }
        }

        return null;
    }

    private static void printAscii(char[] chars){
        for (Character c : chars){
            System.out.print(c + "= " + (int)c + ", "); // 0= 48, 1= 49, 9= 57, A= 65, Z= 90, a= 97, z= 122,
        }
    }
}
