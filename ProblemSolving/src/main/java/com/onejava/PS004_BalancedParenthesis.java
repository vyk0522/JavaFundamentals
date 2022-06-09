package com.onejava;

import java.util.*;

public class PS004_BalancedParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([{}])"));
        System.out.println(isValid("([{]})"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Deque<Character> stack = new ArrayDeque<>();
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            } else if(!stack.isEmpty() && Objects.equals(map.get(stack.peek()), c)){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
