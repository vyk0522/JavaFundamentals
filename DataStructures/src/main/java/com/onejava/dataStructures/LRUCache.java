package com.onejava.dataStructures;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private class Node{
        K key;
        V value;
        Node previous, next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private class DoublyLinkedList{
        Node front, rear;

        /*
            Size is empty: Do nothing.
            Size is 1 front = rear = null
            Size is >1  remove rear by unlinking
         */
        private void removeNodeFromRear(){
            if(rear == null){
                return;
            }
            if(rear == front){
                front = rear = null;
            }
            else{
                rear = rear.previous;
                rear.next = null;
            }
        }

        /*
            Size is empty front = rear = node
            Size is >=1 Add node
         */
        private void addNodeToFront(Node node){
            if(front == null){
                front = rear = node;
            }
            else {
                node.next = front;
                front.previous = node;
                front = node;
            }
        }

        /*
            Node is front: Do nothing.
            Node is rear: remove rear by unlinking and Add node to front
            Node is middle: remove node by unlinking and Add node to front
         */
        private void moveNodeToFront(Node node){
            if(node == front){
                return;
            }
            if(node == rear){
                rear = rear.previous;
                rear.next = null;
            }
            else {
                node.previous.next = node.next;
                node.next.previous = node.previous;
            }
            node.next = front;
            node.previous = null;
            front.previous = node;
            front = node;
        }

    }

    private int capacity, size;
    private Map<K, Node> map = new HashMap<>();
    private DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public V get(K key){
        Node existingNode = map.get(key);
        if (existingNode == null){
            return null;
        }
        doublyLinkedList.moveNodeToFront(existingNode);
        return existingNode.value;
    }

    public void put(K key, V value){
        Node existingNode = map.get(key);
        if(existingNode != null){
            existingNode.value = value;
            doublyLinkedList.moveNodeToFront(existingNode);
            return;
        }

        if(size == capacity){
            map.remove(doublyLinkedList.rear.key);
            doublyLinkedList.removeNodeFromRear();
            size--;
        }

        Node newNode = new Node(key, value);
        doublyLinkedList.addNodeToFront(newNode);
        map.put(key, newNode);
        size++;
    }

    public void print(){
        Node currentNode = doublyLinkedList.front;

        while (currentNode != null){
            System.out.print(currentNode.key + "=" + currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);

        System.out.println("➡️ Adding A=1, B=2, C=3");
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);
        cache.print(); // C B A

        System.out.println("\n➡️ Accessing A (should move to front)");
        cache.get("A");
        cache.print(); // A C B

        System.out.println("\n➡️ Adding D=4 (capacity full → evict LRU=B)");
        cache.put("D", 4);
        cache.print(); // D A C

        System.out.println("\n➡️ Accessing C (should move to front)");
        cache.get("C");
        cache.print(); // C D A
    }


}
