package com.org;

import java.util.HashSet;
import java.util.Set;

public class A005_MaxEmpCanAttendOneOfTwoSession {
    public static void main(String[] args) {
        String[] a = {"039", "4", "14", "32", "", "34", "7"};
        String[] b = {"801234567", "180234567", "0", "189234567", "891234567", "98", "9"};
        String[] c = {"5421", "245", "1452", "0345", "53", "354"};
        System.out.println(solution(a)); // 5
        System.out.println(solution(b)); // 7
    }
    public static int solution(String[] employees) {
        int total = 0;
        for(int day=0; day<10; day++) {  //  0 1 to 9 , 12 to 9, ... last iteration 8,9  ... what happens each iteration? // each iteration attendance
            Set<Integer> attendeesFirst = new HashSet<>();
            int countFirst = countAttendeesOnAday(day, employees, attendeesFirst);
            for(int j=day+1; j<10; j++) {
                Set<Integer> attendeesSecond = new HashSet<>(attendeesFirst);
                int countSecond = countAttendeesOnAday(j, employees, attendeesSecond);
                if(countFirst + countSecond > total) {
                    total = countFirst + countSecond;
                }
            }
        }
        return total;
    }

    public static int countAttendeesOnAday(int day, String[] employees, Set<Integer> attendees) {
        int count = 0;
        for(int i=0; i<employees.length; i++) {
            if(attendees.contains(i)) {
                continue;
            }
            for(int j=0; j<employees[i].length(); j++) {
                if(day==Character.getNumericValue(employees[i].charAt(j))) {
                    attendees.add(i); // to avoid repeating
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }
}
