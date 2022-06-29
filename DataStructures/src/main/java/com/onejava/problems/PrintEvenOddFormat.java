package com.onejava.problems;

import com.onejava.dto.Node;

public class PrintEvenOddFormat {
    public static void main(String[] args) {
        Node head = getEvenOddHead();
        Node result = moveEvenToRightOddToLeft(head, true);
        System.out.println("Printing odd first even last");
        while (result != null){
            System.out.print(result.data + " ");
            result = result.next;
        }

        System.out.println();
        result = moveEvenToRightOddToLeft(head, false);
        System.out.println("Printing even first odd last");
        while (result != null){
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

    private static Node moveEvenToRightOddToLeft(Node<Integer> head, boolean evenRightOddLeft) {
        Node even = null;
        Node evenItr = null; // it iterates and have pointer to the end at the end
        Node odd = null;
        Node oddItr = null; // it iterates and have pointer to the end

        while (head != null){
            if(head.data % 2 == 0){
                if (even == null){
                    even = head;
                    evenItr = head;
                } else{
                    evenItr.next = head;
                    evenItr = evenItr.next;
                }
            } else{
                if (odd == null){
                    odd = head;
                    oddItr = head;
                } else{
                    oddItr.next = head;
                    oddItr = oddItr.next;
                }
            }
            head = head.next;
        }
        // even first odd last
        if (! evenRightOddLeft){
            return evenLeftOddRight(odd, oddItr, even, evenItr);
        }
        // odd first even last
        return oddLeftEvenRight(odd, oddItr, even, evenItr);
    }

    private static Node oddLeftEvenRight(Node odd, Node oddItr, Node even, Node evenItr) {
        if(oddItr != null){
            oddItr.next = even;
        }

        if(evenItr != null){
            evenItr.next = null;
        }
        if (odd != null){
            return odd;
        }
        return even;
    }

    private static Node evenLeftOddRight(Node odd, Node oddItr, Node even, Node evenItr) {
        if(evenItr != null){
            evenItr.next = odd;
        }
        if(oddItr != null){
            oddItr.next = null;
        }
        if (even != null){
            return even;
        }
        return odd;
    }

    private static Node<Integer> getEvenOddHead() {
        Node<Integer> head = new Node<>(17);
        Node<Integer> second = new Node<>(15);
        Node<Integer> third = new Node<>(8);
        Node<Integer> fourth = new Node<>(9);
        Node<Integer> fifth = new Node<>(2);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        return head;
    }
}
