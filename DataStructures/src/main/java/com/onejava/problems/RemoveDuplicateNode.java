package com.onejava.problems;

import com.onejava.dto.Node;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNode {

    public static void main(String[] args) {
        Node<Integer> head = getHead();
        Node<Integer> node = removeDuplicates(head);
        while (node != null){
            System.out.println(node);
            node = node.next;
        }
    }

   /*
   1 -> 2 -> 1 -> 3 -> 5 -> null
  When current node already exists. We need to de-link, meaning point prev node's next to current node's next. current = current.next
  Else add it to set. Assign current to prev and current.next to current

  At end of loop current node points to null and prev node points to last node. Head has the result
    */
    private static Node<Integer> removeDuplicates(Node<Integer> head){
        Node<Integer> prev = null;
        Node<Integer> current = head;
        Set<Integer> set = new HashSet<>();

        while (current != null){
            if (set.contains(current.data)){
                prev.next = current.next;
                current = current.next;
            } else {
                set.add(current.data);
                prev = current;
                current = current.next;
            }
        }

        return head;
    }

    private static Node<Integer> getHead() {
        Node<Integer> head = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(1);
        Node<Integer> fourth = new Node<>(3);
        Node<Integer> fifth = new Node<>(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        return head;
    }
}
