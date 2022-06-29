package com.onejava.Collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Col005_Queue {
    public static void main(String[] args) {
        Queue queue = new PriorityQueue();
        queue.add(10);
        queue.add(1);
        queue.add(1);
       // queue.add(null); // NPE
        // queue.add("abc"); // CCE
        System.out.println(queue); // random sorting - head element is the least value

        Deque list = new LinkedList();
        list.add(10);
        list.add(1);
        list.add(1);
        list.add(null);
        list.add("abc");
        System.out.println(list); // random sorting - head element is the least value


    }
}
