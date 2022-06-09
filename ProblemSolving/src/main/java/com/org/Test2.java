package com.org;

import java.util.HashSet;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {

    }
    public int solution(String[] E) {
        int total = 0;
        for(int i=0; i<10; i++) {
            Set<Integer> attendeesFirst = new HashSet<>();
            int countFirst = countAttendeesOnAday(i, E, attendeesFirst);
            for(int j=i+1; j<10; j++) {
                Set<Integer> attendeesSecond = new HashSet<>(attendeesFirst);
                int countSecond = countAttendeesOnAday(j, E, attendeesSecond);
                if(countFirst + countSecond > total) {
                    total = countFirst + countSecond;
                }
            }
        }
        return total;
    }

    public int countAttendeesOnAday(int day, String[] E, Set<Integer> attendees) {
        int count = 0;
        for(int i=0; i<E.length; i++) {
            if(attendees.contains(i)) {
                continue;
            }
            for(int j=0; j<E[i].length(); j++) {
                if(day==Character.getNumericValue(E[i].charAt(j))) {
                    attendees.add(i);
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }
}
