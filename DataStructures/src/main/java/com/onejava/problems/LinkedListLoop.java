package com.onejava.problems;

import com.onejava.dto.Node;

/*
slow pointer and fast pointer. Distance between both pointers is reduced by 1 in each iteration
Use two pointers slow and fast initialise to head first.
In each iteration move fast to two position and slow to one position.
if fast and slow equals return true.
If fast, slow and fast.nextNode reaches null return false
 */
public class LinkedListLoop {
    public static void main(String[] args) {

    }

    private static Node checkLoop(Node head){
        Node fast = head;
        Node slow = head;

        // if any of these nodes reaches end there is no loop
        while (fast != null && slow != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return slow;
            }

        }
        return null;
    }

    // move one node from 0 position and another from meeting point. Where ever it meets is start of loop
    private static Node startOfLoop(Node head, Node meetingPoint){
        Node start = head;
        while(start != meetingPoint){
            start = start.next;
            meetingPoint = meetingPoint.next;

        }
        return meetingPoint;
    }
}
