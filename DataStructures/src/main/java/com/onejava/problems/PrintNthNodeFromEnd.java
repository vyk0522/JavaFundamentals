package com.onejava.problems;

import com.onejava.dto.Node;

/*
1. Initialize fast and slow nodes with head
2. Move fast node by n-1 positions
3. Move fast and slow nodes by 1 position until fast.next == null.
   Slow node is the answer
 */
public class PrintNthNodeFromEnd {
    public static void main(String[] args) {
        Node<Integer> head = getHead();
        printKthNode(head, 3);
    }

    private static void printKthNode(Node head, int k) {
        Node fast = head;
        Node slow = head;
        int count = 0;

        while(count < k-1){
            fast = fast.next;
            count++;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println("nth node from end: " + slow); // nth node from end
    }



    private static Node<Integer> getHead() {
        Node<Integer> head = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        Node<Integer> fifth = new Node<>(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        return head;
    }


}
