package com.onejava.dataStructures;

import java.util.HashSet;
import java.util.Set;

class Node<V>{
    V value;
    Node<V> next;
    public Node(V value){
        this.value = value;
    }
}

public class LinkedListIntersection {

    public static Node getIntersection(Node headA, Node headB) {
        Set<Node> nodeSet = new HashSet<>();

        Node current = headA;

        while (current != null){
            nodeSet.add(current);
            current = current.next;
        }

        current = headB;

        while (current != null){
            if(nodeSet.contains(current)){
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Node common = new Node(4);
        common.next = new Node(5);

        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = common;

        Node headB = new Node(9);
        headB.next = common;

        Node intersection = getIntersection(headA, headB);
        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.value);
        } else {
            System.out.println("No intersection");
        }
    }



}
